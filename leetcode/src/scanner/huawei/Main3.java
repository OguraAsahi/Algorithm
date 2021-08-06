package scanner.huawei;

import java.util.Scanner;

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
