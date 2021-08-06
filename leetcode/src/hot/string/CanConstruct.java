package hot.string;

public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine){
        int[] chars = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            int index = magazine.charAt(i) - 'a';
            chars[index]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';
            if (chars[index] == 0){
                return false;
            }
            chars[index]--;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean b = new CanConstruct().canConstruct("nagato", "nagato");
        System.out.println(b);
    }

}
