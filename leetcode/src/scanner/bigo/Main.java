package scanner.bigo;

import java.util.Scanner;

public class Main {

    public static Boolean isOld(String v1, String v2){
        String[] s1 = v1.split("\\.");
        String[] s2 = v2.split("\\.");
        // 对主版本号和副版本号判断
        for(int i = 0; i < 2; i++){
            if(s1[i].charAt(0) > s2[i].charAt(0)){
                return true;
            } else if(s1[i].charAt(0) < s2[i].charAt(0)){
                return false;
            }
        }

        if (s2.length == s1.length && s1.length == 2){
            return false;
        }

        if (s1.length > s2.length){
            return true;
        } else if (s1.length < s2.length) {
            return false;
        } else {
            return s1[2].charAt(0) > s2[2].charAt(0);
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println(isOld("1.0.1", "1.1"));
        System.out.println(isOld("2.5", "2.4"));
        System.out.println(isOld("5.4.3", "5.4"));

    }
}
