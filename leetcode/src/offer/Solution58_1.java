package offer;

public class Solution58_1 {
    public String reverseWords(String s){
        if (s == null || "".equals(s)){
            return null;
        }

        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        int len = words.length;
        for (int i = len - 1; i >= 0; --i) {
            if (!" ".equals(words[i])){
                sb = sb.append(words[i]).append(" ");
            }
        }
        s = sb.toString();
        len = s.length();
        return len > 0 ? s.substring(0, len - 1) : "";
    }

    public static void main(String[] args) {
        String s = new Solution58_1().reverseWords("Nice to meet  you!  ");
        System.out.println(s);
    }
}
