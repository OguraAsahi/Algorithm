package scanner.xiaomi.before;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述：
 * 给定一个从1到n的整数列表，从第一个数字开始计数，遇到3的倍数时，将该数从列表中删除，直至列表末尾。
 * 在剩下的数字中，从第一个数字开始，继续之前的计数值，同样遇到3的倍数时，删除该数。
 * 循环上面的步骤，直到列表中只剩下一个数字。
 * 根据指定的数字n，来判断最后剩下的数字是哪个。
 */
public class Main2 {
    /**
     * （1）我们将上述问题建模为函数 f(n, m)
     * （2）首先，长度为 n 的序列会先删除第 m % n 个元素，然后剩下一个长度为 n - 1 的序列。
     *  那么，我们可以递归地求解 f(n - 1, m)，就可以知道对于剩下的 n - 1 个元素，最终会留下第几个元素，我们设答案为 x = f(n - 1, m)。
     * （3）由于我们删除了第 m % n 个元素，将序列的长度变为 n - 1。
     *  当我们知道了 f(n - 1, m) 对应的答案 x 之后，我们也就可以知道，长度为 n 的序列最后一个删除的元素，应当是从 m % n 开始数的第 x 个元素。
     *  因此有 f(n, m) = (m % n + x) % n = (m + x) % n。
     */
    public int solution(int n, int m){
        if (n == 1){
            return 0;
        }
        int x = solution(n - 1, m);
        return (m + x) % n;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int last = new Main2().solution(1, 3);
        System.out.println(last + 1);
    }
}
