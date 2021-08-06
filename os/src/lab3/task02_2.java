package lab3;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class task02_2 {
    public static class MainFrame extends JFrame {
        private static final long serialVersionUID = 1L;

        public MainFrame() {
            JPanel p1 = new JPanel();// 显示框区域
            JScrollPane p2;// 文本框滚动显示在滚动面板
            JPanel p3 = new JPanel();// 介绍区
            JPanel p4 = new JPanel();// 按钮选择区
            JPanel p5 = new JPanel();// 控制按钮选区
            JPanel p6 = new JPanel();// 页面输入区
            JTextArea ta;// 文本框
            setTitle("请求分页存储管理模拟系统");
            setLayout(null);// 使该窗体取消布局管理器设置
            setSize(800, 800);
            Container c = getContentPane();
            Dimension displaySize = Toolkit.getDefaultToolkit().getScreenSize(); // 获得显示器大小对象
            Dimension frameSize = getSize(); // 获得窗口大小对象
            if (frameSize.width > displaySize.width)
                frameSize.width = displaySize.width; // 窗口的宽度不能大于显示器的宽度

            setLocation((displaySize.width - frameSize.width) / 2, (displaySize.height - frameSize.height) / 2); // 设置窗口居中显示器显示

            p1.setBounds(50, 25, 500, 600);
            p1.setBorder(BorderFactory.createTitledBorder("具体的页面置换情况"));

            ta = new JTextArea(50, 35);
            ta.setFont(new Font("标楷体", Font.BOLD, 16)); // 设置当前字体。

            ta.setBackground(Color.white);
            ta.setLineWrap(true); // 设置多行文本框自动换行

            p2 = new JScrollPane(ta);
            p2.setPreferredSize(new Dimension(500, 600)); // 使用了这一句后，就可以显示滚动条了。
            p1.add(p2);
            c.add(p1);

            p3 = new JPanel();
            p3.setBounds(570, 35, 190, 190);
            JTextArea T3 = new JTextArea(12, 15);
            T3.setBounds(0, 0, 190, 190);
            T3.setLineWrap(true); // 设置多行文本框自动换行
            p3.add(T3);
            c.add(p3);

            p4.setLayout(null);
            p4.setBounds(570, 255, 190, 190);
            p4.setBorder(BorderFactory.createTitledBorder("算法选择"));

            JButton B1 = new JButton("Optimal");
            JButton B2 = new JButton("LRU");
            JButton B3 = new JButton("FIFO");
            B1.setBounds(45, 20, 100, 30);
            B2.setBounds(45, 80, 100, 30);
            B3.setBounds(45, 140, 100, 30);

            p4.add(B1);
            p4.add(B2);
            p4.add(B3);
            c.add(p4);

            p5.setLayout(null);
            p5.setBounds(570, 460, 190, 190);

            JButton B4 = new JButton("保存");
            JButton B5 = new JButton("清空");
            JButton B6 = new JButton("退出");
            B4.setBounds(45, 20, 100, 30);
            B5.setBounds(45, 80, 100, 30);
            B6.setBounds(45, 140, 100, 30);
            p5.add(B4);
            p5.add(B5);
            p5.add(B6);
            c.add(p5);

            p6.setLayout(null);
            p6.setBounds(50, 650, 700, 110);
            p6.setBorder(BorderFactory.createTitledBorder("输入区（序列中各访问页面号以逗号“，”或空格符 分开）"));
            JLabel L1 = new JLabel("访问页面号序列:");
            L1.setBounds(20, 55, 100, 25);
            L1.setOpaque(true);// 设置标签为不透明状态

            JTextField T1 = new JTextField();
            T1.setBounds(125, 55, 400, 25);

            JLabel L2 = new JLabel("页块数:");
            L2.setBounds(550, 55, 50, 25);
            L2.setOpaque(true);// 设置标签为不透明状态

            JTextField T2 = new JTextField();// 页块数
            T2.setBounds(610, 55, 80, 25);

            p6.add(T1);
            p6.add(T2);
            p6.add(L1);
            p6.add(L2);
            c.add(p6);

            B1.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    T3.setText("                " + "最佳置换算法\n" + "                "
                            + "（Optimal）\n所选择的淘汰页面是未来最长时间不被访问的，一种理想的置换方法，Optimal算法依据以后各页的使用情况。");
                    // 获取页面号序列
                    String orderList = T1.getText();
                    // 用空格进行分割
                    String temp[] = orderList.split(" ");
                    // 将分割后的页面号存放在数组
                    int page[] = new int[temp.length];
                    for (int i = 0; i < page.length; i++) {
                        try {
                            page[i] = Integer.parseInt(temp[i]);
                        } catch (Exception ex) {
                            T1.setText("装入内存的页面号输入错误，请重新输入!");
                        }
                    }
                    String num = T2.getText();
                    int account = Integer.parseInt(num);

                    int a = 0, m = 0;
                    // 初始化物理块数组
                    Integer[] physical = new Integer[account];
                    // 缺页数
                    int count = 0;

                    ta.setText("Optimal\n");
                    for (int r = 0; r < account; r++) {
                        ta.append("页块" + r + "  ");
                    }
                    ta.append("有无中断" + "  " + "页面置换形式\n");

                    for (int i = 0; i < page.length; i++) {
                        for (int j = 0; j < account; j++) {
                            // 如果内存块数组为空或者不存在即将装入的页面，则将缺页数加一
                            if (physical[j] == null && !Tools.useList(physical, page[i])) {
                                count++;
                                physical[j] = page[i];
                                for (int p = 0; p < account; p++) {
                                    if (String.valueOf(physical[p]) != "null") {
                                        ta.append(String.valueOf(physical[p]) + "          ");
                                    } else {
                                        ta.append("           ");
                                    }

                                }
                                ta.append("√" + "           " + "插入页面\n");
                            }
                        }
                        if (physical[account - 1] != null) {
                            a = i + 1;
                            break;
                        }
                    }
                    // int[] 转 Integer[]
                    Integer[] array1 = Arrays.stream(page).boxed().toArray(Integer[]::new);
                    for (m = a; m < page.length; m++) {
                        if (!Tools.useList(physical, page[m])) {
                            Integer[] array2 = Arrays.copyOfRange(array1, m, page.length + 1);
                            physical[Tools.exchange(array2, physical, account)] = page[m];
                            count++;
                            for (int p = 0; p < account; p++) {
                                if (String.valueOf(physical[p]) != "null") {
                                    ta.append(String.valueOf(physical[p]) + "          ");
                                } else {
                                    ta.append("           ");
                                }

                            }
                            ta.append("√" + "           " + "替换页面\n");
                        } else {
                            for (int u = 0; u < account; u++) {
                                ta.append(String.valueOf(physical[u]) + "          ");
                            }
                            ta.append("\t\t\n");
                        }

                    }
                    ta.append("\nOptimal算法" + "    " + "总页数：" + page.length + "    " + "缺页中断次数：" + count + "    " + "缺页率："
                            + (double) count / page.length);
                }
            });
            B2.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    T3.setText("        " + "最近最久未使用置换算法\n" + "                     " + "(LRU)\n是根据页面调入内存后的使用情况做出决策的");
                    // 获取页面号序列
                    String orderList = T1.getText();
                    // 用空格进行分割
                    String temp[] = orderList.split(" ");
                    // 将分割后的页面号存放在数组
                    int page[] = new int[temp.length];
                    for (int i = 0; i < page.length; i++) {
                        try {
                            page[i] = Integer.parseInt(temp[i]);
                        } catch (Exception ex) {
                            T1.setText("装入内存的页面号输入错误，请重新输入!");
                        }
                    }
                    String num = T2.getText();
                    int account = Integer.parseInt(num);

                    int a = 0, m = 0;
                    // 初始化物理块数组
                    Integer[] physical = new Integer[account];
                    // 缺页数
                    int count = 0;
                    int record = 0;//记录相同页面位置

                    ta.setText("LRU\n");
                    for (int r = 0; r < account; r++) {
                        ta.append("页块" + r + "  ");
                    }
                    ta.append("有无中断" + "  " + "页面置换形式\n");

                    for (int i = 0; i < page.length; i++) {
                        for (int j = 0; j < account; j++) {
                            // 如果内存块数组为空或者不存在即将装入的页面，则将缺页数加一
                            if (physical[j] == null && !Tools.useList(physical, page[i])) {
                                count++;
                                physical[j] = page[i];
                                for (int p = 0; p < account; p++) {
                                    if (String.valueOf(physical[p]) != "null") {
                                        ta.append(String.valueOf(physical[p]) + "          ");
                                    } else {
                                        ta.append("           ");
                                    }

                                }
                                ta.append("√" + "           " + "插入页面\n");
                            }
                        }
                        if (physical[account - 1] != null) {
                            a = i + 1;
                            break;
                        }
                    }
                    for (m = a; m < page.length; m++) {
                        if (!Tools.useList(physical, page[m])) {
                            for (int k = 0; k < account - 1; k++) {
                                physical[k] = physical[k + 1];
                            }
                            physical[account - 1] = page[m];
                            count++;
                            for (int p = 0; p < account; p++) {
                                if (String.valueOf(physical[p]) != "null") {
                                    ta.append(String.valueOf(physical[p]) + "          ");
                                } else {
                                    ta.append("           ");
                                }

                            }
                            ta.append("√" + "           " + "替换页面\n");
                        } else {
                            for (int c = 0; c < account; c++) {
                                if (page[m] == physical[c]) {
                                    record = c;
                                }
                            }
                            for (int d = record; d < account - 1; d++) {
                                physical[d] = physical[d + 1];
                            }
                            physical[account - 1] = page[m];
                            for (int u = 0; u < account; u++) {
                                ta.append(String.valueOf(physical[u]) + "          ");
                            }
                            ta.append("\t\t\n");
                        }

                    }
                    ta.append("\nLRU算法" + "    " + "总页数：" + page.length + "    " + "缺页中断次数：" + count + "    " + "缺页率："
                            + (double) count / page.length);
                }
            });
            B3.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    T3.setText("        " + "先进先出页面置换算法\n" + "                     "
                            + "(FIFO)\n该算法总是淘汰最先进入的页面，即选择在内存中驻留时间最久的页面予以淘汰。");
                    // 获取页面号序列
                    String orderList = T1.getText();
                    // 用空格进行分割
                    String temp[] = orderList.split(" ");
                    // 将分割后的页面号存放在数组
                    int page[] = new int[temp.length];
                    for (int i = 0; i < page.length; i++) {
                        try {
                            page[i] = Integer.parseInt(temp[i]);
                        } catch (Exception ex) {
                            T1.setText("装入内存的页面号输入错误，请重新输入!");
                        }
                    }
                    String num = T2.getText();
                    int account = Integer.parseInt(num);

                    int a = 0, m = 0;
                    // 初始化物理块数组
                    Integer[] physical = new Integer[account];
                    // 缺页数
                    int count = 0;

                    ta.setText("FIFO\n");
                    for (int r = 0; r < account; r++) {
                        ta.append("页块" + r + "  ");
                    }
                    ta.append("有无中断" + "  " + "页面置换形式\n");

                    for (int i = 0; i < page.length; i++) {
                        for (int j = 0; j < account; j++) {
                            // 如果内存块数组为空或者不存在即将装入的页面，则将缺页数加一
                            if (physical[j] == null && !Tools.useList(physical, page[i])) {
                                count++;
                                physical[j] = page[i];
                                for (int p = 0; p < account; p++) {
                                    if (String.valueOf(physical[p]) != "null") {
                                        ta.append(String.valueOf(physical[p]) + "          ");
                                    } else {
                                        ta.append("           ");
                                    }

                                }
                                ta.append("√" + "           " + "插入页面\n");
                            }
                        }
                        if (physical[account - 1] != null) {
                            a = i + 1;
                            break;
                        }
                    }
                    int d = 0;
                    for (m = a; m < page.length; m++) {
                        if (!Tools.useList(physical, page[m])) {
                            if (d == 3) {
                                d = 0;
                            }
                            physical[d] = page[m];

                            d++;
                            count++;
                            for (int p = 0; p < account; p++) {
                                if (String.valueOf(physical[p]) != "null") {
                                    ta.append(String.valueOf(physical[p]) + "          ");
                                } else {
                                    ta.append("           ");
                                }

                            }
                            ta.append("√" + "           " + "替换页面\n");
                        } else {
                            for (int u = 0; u < account; u++) {
                                ta.append(String.valueOf(physical[u]) + "          ");
                            }
                            ta.append("\t\t\n");
                        }
                    }
                    ta.append("\nFIFO算法" + "    " + "总页数：" + page.length + "    " + "缺页中断次数：" + count + "    " + "缺页率："
                            + (double) count / page.length);
                }
            });

            B4.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    JFileChooser fileChooser = new JFileChooser();//创建文件选择对话框
                    int i = fileChooser.showOpenDialog(getContentPane());//显示文件选择对话框
                    if (i == JFileChooser.APPROVE_OPTION) {//判断用户点击的是否为“打开”按钮
                        String selectedFile = fileChooser.getSelectedFile().getAbsolutePath();//获得选中的文件对象
                        File file = new File(selectedFile);//创建文件对象
                        try {
                            FileWriter out = new FileWriter(file);//创建FileWriter对象
                            String s = ta.getText();//获取文本域的文本
                            out.write(s);//将消息写入磁盘文件
                            out.close();//将流关闭
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }

                }
            });

            B5.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    ta.setText("");

                }
            });

            B6.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    System.exit(0);
                }
            });

            setVisible(true); // 设置窗口为可见的，默认为不可见
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
    public static void main(String args[]) {
        new MainFrame();
    }
}
