package hot.string;

public class MyAtoi {
    public int myAtoi(String s){
        if (s == null){
            return 0;
        }
        s = s.trim();
        int n = s.length();
        if (n == 0){
            return 0;
        }
        int i = 0;
        int sign = 1;
        if (s.charAt(i) == '-'){
            sign = -1;
        }
        if (s.charAt(i) == '-' || s.charAt(i) == '+'){
            i++;
        }
        int res = 0, flag = Integer.MAX_VALUE / 10;
        for (; i < n; i++){
            if (s.charAt(i) < '0' || s.charAt(i) > '9'){
                break;
            }
            if (res > flag || (res == flag && s.charAt(i) > '7')){
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (s.charAt(i) - '0');
        }
        return res * sign;
    }

    public static void main(String[] args) {
        int i = new MyAtoi().myAtoi("    -99999abc");
        System.out.println(i);
    }
}
