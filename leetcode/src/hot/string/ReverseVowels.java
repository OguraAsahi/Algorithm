package hot.string;

public class ReverseVowels {
    public String reverseVowels(String s){
        if (s == null){
            return null;
        }
        char[] chars = s.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l < r){
            if (!isVowel(chars[l])){
                ++l;
                continue;
            }
            if (!isVowel(chars[r])){
                --r;
                continue;
            }
            swap(chars, l++, r--);
        }
        return String.valueOf(chars);
    }

    public void swap(char[] chars, int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public boolean isVowel(char c){
        switch (c){
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
            default:
                return false;
        }
    }

    public static void main(String[] args) {
        String s = new ReverseVowels().reverseVowels("abcdefg");
        System.out.println(s);
    }
}
