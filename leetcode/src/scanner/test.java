package scanner;

import java.util.Random;

public class test {

    private static int rand(int n){
        return new Random().nextInt(5) + 1;
    }

    //使用rand(5)产生rand(7)
    private static int random7(){
        int x = Integer.MAX_VALUE;
        while (x > 21){
            x = (rand(5)  - 1) * 5 + rand(5);
        }
        return (x % 7 + 1);
    }


    private static int random5() {
        int a, idx;
        while (true) {
            a = rand(3);
            idx = rand(3) + (a - 1) * 3;  // [1...9]
            if (idx <= 5) {
                return idx;
            }
            a = idx - 5;  // [1...4]
            idx = rand(3) + (a - 1) * 3;  // [1...12]
            if (idx <= 10) {
                return (idx - 1) % 5 + 1;
            }
            a = idx - 10; // [1, 2]
            idx = rand(3) + (a - 1) * 3; // [1...6]
            if (idx <= 5) {
                return idx;
            }
            // a = idx - 5; a == 1 只剩下一个数 最多也就实现 [1...3]的范围，无法实现rand5()也就只能重新开始
        }
    }

    public static void main(String[] args) {
        int i = random7();
        System.out.println(i);
    }
}
