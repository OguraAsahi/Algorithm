package offer;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 *
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字 2，该函数将返回左旋转两位得到的结果"cdefgab"。
 */
public class Solution58_2 {
    public String reverseLeftWords(String s, int n){
        if (s == null || n > s.length() || "".equals(s)){
            return null;
        }
        return s.substring(n) + s.substring(0, n);
    }


    public static void main(String[] args) {
        String s = new Solution58_2().reverseLeftWords("lrloseumgh", 6);
        System.out.println(s);
    }
}
