import java.util.Scanner;

public class CCF201912_1 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt() + 1;
        int[] counter = new int[4];
        int k = 1;
        while (k < n){
            if (canContinue(k)){
                counter[(k - 1) % 4]++;
                n++;
            }
            k++;
        }
        for (int i = 0; i < 4; i++) {
            System.out.println(counter[i]);
        }
    }
    public static boolean canContinue(int k){
        if (k % 7 == 0){
            return  true;
        }
        while (k > 0){
            if (k % 10 == 7){
                return true;
            }
            k /= 10;
        }
        return false;
    }
}
