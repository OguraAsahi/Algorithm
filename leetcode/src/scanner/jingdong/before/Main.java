package scanner.jingdong.before;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 求公约数，一个长为n的01字符串, 其前缀能分成最多多少组的等比切割串
 */
public class Main {

    public void solution(int n, String str){
        int zero = 0, one = 0;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '0'){
                zero++;
            } else {
                one++;
            }
            int gcd = 0;
            if (zero != 0 && one != 0){
                gcd = gcd(zero, one);
                nums[i] = gcd == 1 ? 1 : gcd;
            } else {
                nums[i] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(nums[i]);
        }

    }

    private int gcd(int zero , int one){
        return (zero % one == 0) ? one : gcd(one, zero % one);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //int n = in.nextInt();
        //String str = in.nextLine();
        int n = 9;
        String str = "010100111";
        new Main().solution(n, str);
    }
}
