package scanner.xiaomi;

import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public int[] solution(int[] nums){
        Arrays.sort(nums);
        return nums;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] nums = new int[10];
        for (int i = 0; i < 10; i++) {
            nums[i] = in.nextInt();
        }
        int[] solution = new Main().solution(nums);
        for (int i = 0; i < 10; i++) {
            System.out.print(solution[i]);
        }
    }
}
