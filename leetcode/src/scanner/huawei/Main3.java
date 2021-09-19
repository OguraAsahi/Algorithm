package scanner.huawei;

import java.util.Scanner;

/**
 * 第三题 无线设备传输
 * 题目
 * 无线设备传输过程中，数据经常需要通过各种中继设备进行中转。
 * 有某段传输路径，每隔1km放置1个中继设备用于数据中转，现用一数组来描述包括起始点的所有中继设备的最大传输距离。
 * 求从起点到终点，能完成信号传输的最少中转次数。
 * 输入描述：
 * 4
 * 2 3 1 1
 * 第一行代表总共中转设备台数，4台
 * 第二行表示各中转设备的最大传输能力。
 *
 * 解析
 * 读完这道题目，发现这是一道跳跃游戏类的题，只是把问题实际化了。所以本题可以用贪心算法来做，贪心算法的主要思想就是由局部最优得到全局最优。
 *
 * 比如输入是【2，1，3，1，2】，本题想得到的最少的中转次数。
 * 我们可以从尾往前看：先找到能一次达到尾巴的最远点，即3的位置；第二步，再找3之前能到达3的最远的，那么直接就是2。
 * 由局部最优得全局最优，得到最小中转次数，也就是2次。
 */
public class Main3 {
    public static int jump(int[] nums){
        // 记录中转次数
        int count = 0;
        int len = nums.length;
        int i = 0;
        // 从后往前看, 找到能一次到达末尾的最远点, 然后更新末尾的位置即可
        while (len > 1){
            // 当前站台的传播距离大于距离尾距离
            if (nums[i] >= len - 1 - i){
                // 计数
                count++;
                // 更新剩下的站台数量
                len = i + 1;
                // 清0, 从头开始遍历
                i = 0;
            } else {
                // 如果不是最佳的传播距离, 则继续往后找
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n == 0 || n == 1){
            System.out.println(0);
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int res = jump(nums);
        System.out.println(res);
    }
}
