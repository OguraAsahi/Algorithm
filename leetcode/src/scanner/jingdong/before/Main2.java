package scanner.jingdong.before;

import java.util.Scanner;

/**
 * 类丑数问题(丑数中2,3,5是因子)
 *
 * 按一定规则构成的第n个数，如只包含2,3,5。则从2开始升序列出第n个该数
 */
public class Main2 {

    public void solution(int n){
        int i1 = 0, i2 = 1, i3 = 2;
        int[] nums = new int[1000];
        nums[0] = 2;
        nums[1] = 3;
        nums[2] = 5;
        int i = 3;
        while (i < 1000){
            int l = 0;
            int cur = 0;
            for (l = 0; l < 3; l++){
                cur = nums[i1] * 10;
                if (l == 0&& i < 1000){
                    cur += 2;
                    nums[i++] = cur;
                } else if (l == 1 && i < 1000){
                    cur += 3;
                    nums[i++] = cur;
                } else if (l == 2 && i < 1000){
                    cur += 5;
                    nums[i++] = cur;
                }
            }
            i1 += 3;
            for (l = 0; l < 3; l++){
                cur = nums[i2] * 10;
                if (l == 0&& i < 1000){
                    cur += 2;
                    nums[i++] = cur;
                } else if (l == 1 && i < 1000){
                    cur += 3;
                    nums[i++] = cur;
                } else if (l == 2 && i < 1000){
                    cur += 5;
                    nums[i++] = cur;
                }
            }
            i2 += 3;
            for (l = 0; l < 3; l++){
                cur = nums[i3] * 10;
                if (l == 0&& i < 1000){
                    cur += 2;
                    nums[i++] = cur;
                } else if (l == 1 && i < 1000){
                    cur += 3;
                    nums[i++] = cur;
                } else if (l == 2 && i < 1000){
                    cur += 5;
                    nums[i++] = cur;
                }
            }
            i3 += 3;
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
    }
}
