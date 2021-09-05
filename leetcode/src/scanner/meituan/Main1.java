package scanner.meituan;

import java.util.Scanner;

public class Main1 {
    public Long solution(int n){
        if(n < 3){
            return n == 2 ? 4L : 2L;
        }
        long count = 6L;
        long a = 2L, b = 2L;
        for (int i = 3; i < n; i++) {
            Long t = b;
            b += a % 998244353L;
            a = t;
            count += b;
            count = count % 998244353L;
        }
        return (count % 998244353L);
    }



    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Long solution = new Main1().solution(n);
        System.out.println(solution);
    }
}
