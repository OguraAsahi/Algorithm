import java.util.Scanner;

public class Demo_谁是高富帅{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n,m;
        String str1 = input.nextLine();
        String[] s1 = str1.split(" ");
        n = Integer.parseInt(s1[0]);
        m = Integer.parseInt(s1[1]);
        int[] num1 = new int[n];
        int[] num2 = new int[n];
        int[] num3 = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            String str = input.nextLine();
            String[] s = str.split(" ");
            num1[i] = Integer.parseInt(s[0]);
            num2[i] = Integer.parseInt(s[1]);
            num3[i] = Integer.parseInt(s[2]);
            for (int j = 0; j < i; j++) {
                if(num1[j] >= num1[i] && num2[j] >= num2[i] && num3[j] >= num3[i])
                    rank[j]++;
                else if(num1[j] <= num1[i] && num2[j] <= num2[i] && num3[j] <= num3[i]){
                    rank[i]++;
                }

            }
        }
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            count[rank[i]]++;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(count[i]);
        }
    }
}
