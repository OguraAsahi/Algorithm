package scanner;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static int magicBolls(long[] nums){
        int n = nums.length;
        int cnt = 0;
        int sum = 0;
        int flag = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            flag = i;
            while (i < n - 1 && sum >= nums[i + 1] ){
                sum += nums[i + 1];
                if (sum > nums[n - 1]){
                    cnt = n - flag;
                    return cnt;
                }
                i++;
            }
        }
        return cnt;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n == 0){
            System.out.println(0);
            return;
        }
        long[] nums = new long[n];
        int i = 0;
        while (n-- > 0) {
            nums[i] = in.nextLong();
            i++;
        }
        Arrays.sort(nums);
        int res = magicBolls(nums);
        System.out.println(res);
    }
}
