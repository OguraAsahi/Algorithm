package lab3;

import java.util.Random;
public class task02 {
    static final int MAX_VIR_SIZE = 64;
    static final int MAX_MEM_SIZE = 32;
    static final int VIR_NO = 2;
    static final int MEM_NO = 3;
    static final int FALSE = -1;
    static int[] mem_frame = new int[MAX_MEM_SIZE];        //内存帧
    static int[] instruction = new int[MAX_VIR_SIZE * 10];   //指令序列
    static int[] reference = new int[MAX_VIR_SIZE * 10];     //引用串
    static int[] mem_size = { 4, 18, 32 }; //内存容量
    static int[] vir_size = { 32, 64 };    //虚存容量

    public static void main(String[] args) {
        int vir_no, vsize, ref_len;

        for (vir_no = 0; vir_no < VIR_NO; vir_no++) {
            initialize();  //初始化虚拟存储区
            vsize = vir_size[vir_no]; //获取虚拟存储区大小

            ref_len = generate_page(vsize);

            System.out.println("Algorithm\tMemory/Virtual\tRate");
            //最优页置换(OPT)
            OPT(ref_len, vsize);
            //先进先出页置换(FIFO)
            FIFO(ref_len, vsize);
            //最近最少使用页置换(LRU)
            LRU(ref_len, vsize);
            //最不经常使用页置换(LFU)
            LFU(ref_len, vsize);
            //最近未使用页置换(NUR)
            NUR(ref_len, vsize);

            System.out.println();
        }
    }

    /**
     * 初始化页地址流
     */
    static void initialize()
    {
        for (int i = 0; i < MAX_VIR_SIZE * 10; i++) {
            instruction[i] = -1;
            reference[i] = -1;
        }
    }

    /**
     * 初始化内存工作区
     */
    static void ini_mem()
    {
        for (int i = 0; i < MAX_MEM_SIZE; i++)
            mem_frame[i] = -1;
    }

    static int generate_page(int vsize)
    {
        Random random = new Random();
        //产生指令序列
        for (int i = 0; i < vsize * 10; i += 5) {
            instruction[i] = random.nextInt() % (vsize * 10 - 1);
            instruction[i + 1] = instruction[i] + 1;
            instruction[i + 2] = random.nextInt() % instruction[i + 1];
            instruction[i + 3] = instruction[i + 2] + 1;
            instruction[i + 4] = random.nextInt() % (vsize * 10 - instruction[i + 3] - 2) + instruction[i + 3] + 1;
        }

        //将指令序列变换为对应的页地址流
        for (int i = 0; i < vsize * 10; i++)
            instruction[i] /= 10;

        reference[0] = instruction[0];

        int base = 0, j = 1;
        for (int i = 1; i < vsize * 10; i++) {
            if (instruction[i] != instruction[base]) {
                reference[j] = instruction[i];
                j++;

                base = i;
            }
        }
        return j;    //返回引用串，即页地址流的长度
    }

    /**
     * 在内存帧中寻找页
     */
    static int search(int msize, int key)
    {
        for (int i = 0; i < msize; i++) {
            if (mem_frame[i] == -1)       //内存工作区未满
                return i;
            else if (mem_frame[i] == key) //找到页对应的帧
                return i;
        }
        return FALSE;                     //内存工作区已满且没找到
    }

    /**
     * 最优页置换
     */
    static void OPT(int ref_len, int vsize)
    {
        int mem_no, msize, i, find, miss, j, k;
        int first;
        int longest, rep = 0;
        float rate = 0;

        System.out.print("OPT");

        for (mem_no = 0; mem_no < MEM_NO; mem_no++) {
            miss = 0;
            ini_mem();                          //初始化内存工作区
            msize = mem_size[mem_no];
            for (i = 0; i < ref_len; i++) {
                find = search(msize, reference[i]);
                if (find != FALSE && mem_frame[find] == -1) {     //内存工作区未满
                    miss++;
                    mem_frame[find] = reference[i];//页置换
                }
                else if (find == FALSE) {        //内存工作区已满且没找到
                    miss++;
                    longest = 0;
                    first = 0;
                    for (j = 0; j < msize; j++) {
                        for (k = i + 1; k < ref_len; k++) {
                            if (mem_frame[j] == reference[k]) {
                                if (k > longest) {
                                    longest = k;
                                    rep = j;     //找到向前看距离最远的一帧
                                }
                                break;
                            }
                            if (k == ref_len && first == 0) {
                                longest = k;
                                first = 1;
                                rep = j;
                            }
                        }
                    }
                    mem_frame[rep] = reference[i];//页置换
                }
                else//找到页对应的帧
                    ;
            }
            rate = 1 - ((float)miss) / ((float)ref_len);          //计算命中率
            System.out.println("\t\t\t\t" +  msize + "/" + vsize + "\t\t" + rate);
        }
    }

    /**
     * 先进先出页置换
     */
    static void FIFO(int ref_len, int vsize)
    {
        System.out.println();
        System.out.print("FIFO");
        for (int mem_no = 0; mem_no < MEM_NO; mem_no++) {
            int miss = 0;
            ini_mem(); //初始化内存工作区
            int msize = mem_size[mem_no];
            int rep = 0;
            for (int i = 0; i < ref_len; i++) {
                int find = search(msize, reference[i]);
                //内存工作区未满
                if (find != FALSE && mem_frame[find] == -1) {
                    miss++;
                    mem_frame[find] = reference[i];
                }
                //内存工作区已满且没找到
                else if (find == FALSE) {
                    miss++;
                    mem_frame[rep] = reference[i];//页置换
                    //下一个将要被置换的帧的位置
                    rep = (rep + 1) % msize;
                }
                else//找到页对应的帧
                    ;
            }
            float rate = 1 - ((float)miss) / ((float)ref_len);           //计算命中率
            System.out.println("\t\t\t" +  msize + "/" + vsize + "\t\t" + rate);
            System.out.print("\t");
        }
    }

    //函数：最近最少使用页置换
    static void LRU(int ref_len, int vsize)
    {
        int mem_no, msize, i, find, miss, j, k, longest, rep = 0, dis;
        float rate = 0;
        System.out.println();
        System.out.print("LRU");

        for (mem_no = 0; mem_no < MEM_NO; mem_no++) {
            miss = 0;
            ini_mem();  //初始化内存工作区
            msize = mem_size[mem_no];
            for (i = 0; i < ref_len; i++) {
                find = search(msize, reference[i]);
                //内存工作区未满
                if (find != FALSE && mem_frame[find] == -1) {
                    miss++;
                    mem_frame[find] = reference[i];//页置换
                }
                //内存工作区已满且没找到
                else if (find == FALSE) {
                    miss++;
                    longest = 0;
                    for (j = 0; j < msize; j++) {
                        for (k = i - 1; k >= 0; k--) {
                            if (mem_frame[j] == reference[k]) {
                                dis = i - k;
                                if (dis > longest) {
                                    longest = dis;
                                    rep = j;     //找到向后看距离最远的一帧
                                }
                                break;
                            }
                        }
                    }
                    mem_frame[rep] = reference[i];//页置换
                }
                else//找到页对应的帧
                    ;
            }
            rate = 1 - ((float)miss) / ((float)ref_len);          //计算命中率
            System.out.println("\t\t\t\t" +  msize + "/" + vsize + "\t\t" + rate);
        }
    }

    /**
     * 最不经常使用页置换
     */
    static void LFU(int ref_len, int vsize)
    {
        int mem_no, msize, i, j, find, miss, rep, least;
        //计数器：记录内存帧被使用的次数
        int[] count = new int[MAX_MEM_SIZE];
        float rate = 0;

        System.out.println();
        System.out.print("LFU");

        for (mem_no = 0; mem_no < MEM_NO; mem_no++) {
            miss = 0;
            ini_mem(); //初始化内存工作区
            msize = mem_size[mem_no];
            //初始化内存工作区每帧的计数器
            for (i = 0; i < msize; i++)
                count[i] = 0;
            for (i = 0; i < ref_len; i++) {
                find = search(msize, reference[i]);
                //内存工作区未满
                if (find != FALSE && mem_frame[find] == -1) {
                    miss++;
                    mem_frame[find] = reference[i];
                }
                else if (find == FALSE) {//内存工作区已满且没找到
                    miss++;
                    least = count[0];
                    rep = 0;
                    for (j = 1; j < msize; j++) {//选择计数器值最小的帧
                        if (count[j] < least) {
                            least = count[j];
                            rep = j;
                        }
                    }
                    mem_frame[rep] = reference[i];//页置换
                    count[rep] = 0;
                }
                else//找到页对应的帧
                    count[find] ++;

                if ((i + 1) % 32 == 0) { //计数器定期衰减
                    for (j = 0; j < msize; j++)
                        count[j] /= 2;
                }
            }
            //计算命中率
            rate = 1 - ((float)miss) / ((float)ref_len);
            System.out.println("\t\t\t\t" +  msize + "/" + vsize + "\t\t" + rate);
        }
    }

    /**
     * 最近未使用页置换
     */
    static void NUR(int ref_len, int vsize)
    {
        int mem_no, msize, i, find, miss, rep, least;
        int[] flag = new int[MAX_MEM_SIZE]; //访问位
        float rate = 0;
        int m;

        System.out.println();
        System.out.print("NUR");

        for (mem_no = 0; mem_no < MEM_NO; mem_no++) {
            miss = 0;
            ini_mem(); //初始化内存工作区
            msize = mem_size[mem_no];
            //初始化内存工作区每帧的计数器
            for (i = 0; i < msize; i++)
                flag[i] = 0;
            rep = 0;
            for (i = 0; i < ref_len; i++) {
                find = search(msize, reference[i]);
                if (find != FALSE && mem_frame[find] == -1) { //内存工作区未满
                    miss++;
                    mem_frame[find] = reference[i];
                }
                //内存工作区已满且没找到
                else if (find == FALSE) {
                    miss++;
                    //最近被使用过，给第二次机会
                    while (flag[rep] != 0) {
                        flag[rep] = 0;
                        rep = (rep + 1) % msize;
                    }
                    mem_frame[rep] = reference[i];//页置换
                    rep = (rep + 1) % msize;
                }
                else//找到页对应的帧
                    flag[find] = 1;
            }
            //计算命中率
            rate = 1 - ((float)miss) / ((float)ref_len);
            System.out.println("\t\t\t\t" +  msize + "/" + vsize + "\t\t" + rate);
        }
    }
}
