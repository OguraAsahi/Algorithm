package lab3;

import java.util.Date;

public class task01 {
    public static void main(String[] args) throws InterruptedException {
        //method01();
        method02();
    }

    private static void method01() throws InterruptedException {
        long begin = System.currentTimeMillis();
        int[][] Array = new int[4096][4096];
        for (int i = 0; i < 4096; i++) {
            for (int j = 0; j < 4096; j++) {
                Array[i][j] = 0;
            }
        }
        System.out.println("共用时:" + (double) (System.currentTimeMillis() - begin) + "毫秒");
        long end = System.currentTimeMillis();
        Thread.sleep(50000);
    }

    private static void method02() throws InterruptedException {
        long begin = System.currentTimeMillis();
        int[][] Array = new int[4096][4096];
        for (int j = 0; j < 4096; j++) {
            for (int i = 0; i < 4096; i++) {
                Array[i][j] = 0;
            }
        }
        System.out.println("共用时:" + (double) (System.currentTimeMillis() - begin) + "毫秒");
        long end = System.currentTimeMillis();
        Thread.sleep(50000);
    }
}
