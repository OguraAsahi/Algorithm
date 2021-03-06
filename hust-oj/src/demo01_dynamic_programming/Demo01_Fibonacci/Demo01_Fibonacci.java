package demo01_dynamic_programming.Demo01_Fibonacci;

import java.util.Scanner;

/*
    ้ๆฑ:
                1	๐๐ ๐ = 0 ๐๐ 1
        ๐น(๐) =
                ๐น(๐โ1) + ๐น(๐โ2)	๐๐ ๐ > 1
        ้ๅฝ็ๆฌ:
        F(n)
        1	if n==0 or n==1 then
        2		return 1
        3	else
        4		return F(n-1) + F(n-2)

 */
public class Demo01_Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //Fibonacci1(n);
        Fibonacci2(n);
        System.out.println(Fibonacci3(n));
    }

    // ๅจๆ่งๅ้ๅฝไน่ฎฐๅฟๅๆ็ดข็ๆฌ:
    static int[] A = new int[50];
    public static int Fibonacci3(int n) {
        A[1] = A[2] = 1;
        if (A[n]>0)
            return A[n];
        else {
            A[n] = Fibonacci3(n-1)+Fibonacci3(n-2);
            return Fibonacci3(n-1) + Fibonacci3(n-2);
        }
    }

    // ๅจๆ่งๅ้ๆจๅผบ่ฟซ็็ๆฌ:
    public static void Fibonacci2(int n) {
        int A , A0, A1;
        A = A0 = A1 = 1;
        for (int i = 2; i < n; i++) {
            A = A0 + A1;
            A0=A1;
            A1=A;
        }
        System.out.println(A);
    }

    // ๅจๆ่งๅ้ๆจ็ๆฌ:
    public static void Fibonacci1(int n) {
        int[] A = new int[n];
        A[0] = A[1] = 1;
        for (int i = 2; i < n; i++) {
            A[i] = A[i - 1] + A[i - 2];
        }
        System.out.println(A[n - 1]);
    }
}
