package offer;

/**
 * 求 1+2+...+n，要求不能使用乘除法、for、while、if、else、switch、case 等关键字及条件判断语句（A?B:C）。
 */
public class Solution64 {
    public int sumNums(int n) {
        int s = n;
        // 利用了&&比较运算符的特性, 当前面的条件不满足时就不再判断
        // 在&&后面利用递归来对s进行累加
        boolean t = n > 0 && (s += sumNums(n - 1)) > 0;
        return s;
    }

    public static void main(String[] args) {
        int i = new Solution64().sumNums(10);
        System.out.println(i);
    }
}
