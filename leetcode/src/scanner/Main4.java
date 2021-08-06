package scanner;

import java.util.Scanner;

public class Main4 {

    public static int transport(int[] nums){
        int n = nums.length;
        int pos = 0;
        int res = 0;
        int flag = 0;
        if (nums[0] >= n - 1){
            return 1;
        }
        while (pos < n - 1){
            int max = nums[pos];
            if (pos + max >= n - 1){
                res++;
                break;
            }
            for (int i = pos + 1; i <= pos + nums[pos]; i++) {
                if (max <= i + nums[i] - pos){
                    max = nums[i];
                    flag = i;
                }
            }
            pos = flag;
            res++;
        }
        return res;
        // 7
        // 3 3 3 1 1 1 1有问题
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n == 0 || n == 1){
            System.out.println(0);
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int res = transport(nums);
        System.out.println(res);
    }

}
