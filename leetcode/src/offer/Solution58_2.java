package offer;

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
