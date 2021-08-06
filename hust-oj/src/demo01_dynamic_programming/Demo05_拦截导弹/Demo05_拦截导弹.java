package demo01_dynamic_programming.Demo05_拦截导弹;

import javax.xml.crypto.AlgorithmMethod;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.AlgorithmConstraints;
import java.util.Scanner;

/*
    某国为了防御敌国的导弹袭击，发展出一种导弹拦截系统。但是这种导弹拦截系统有一个缺陷：
    虽然它的第一发炮弹能够到达任意的高度，但是以后每一发炮弹都不能高于前一发的高度。
    某天，雷达捕捉到敌国的导弹来袭。由于该系统还在试用阶段，所以只有一套系统，
    因此有可能不能拦截所有的导弹。输入导弹依次飞来的高度（雷达给出的高度数据是不大于30000的正整数），
    计算这套系统最多能拦截多少导弹，如果要拦截所有导弹最少要配备多少套这种导弹拦截系统。
    最长不升子序列
 */
public class Demo05_拦截导弹 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        String[] s = str.split(" ");
        int[] num = new int[s.length];
        for(int i=0; i<s.length; i++) num[i] = Integer.parseInt(s[i]);
        int[] dp_1 = new int[s.length];
        int[] dp_2 = new int[s.length];
        for(int i=0; i<s.length; i++) {
            dp_1[i] = 1; dp_2[i] = 1;
        }
        for(int i=0; i<s.length; i++) {
            for(int j=0; j<i; j++) {
                if(num[i]<=num[j]) {
                    dp_1[i] = Math.max(dp_1[i], dp_1[j]+1);
                }else {
                    dp_2[i] = Math.max(dp_2[i], dp_2[j]+1);
                }
            }
        }
//		for(int i=0; i<s.length; i++) System.out.print(dp_1[i]+" ");
//		System.out.println();
//		for(int i=0; i<s.length; i++) System.out.print(dp_2[i]+" ");
//		System.out.println();
        int ans_1 = -1, ans_2 =-1;
        for(int i = 0; i<s.length; i++) {
            ans_1 = Math.max(ans_1, dp_1[i]);
            ans_2 = Math.max(ans_2, dp_2[i]);
//			System.out.print(num[i]+" ");
        }
//		System.out.println();
        System.out.println(ans_1);
        System.out.println(ans_2);

    }


}
