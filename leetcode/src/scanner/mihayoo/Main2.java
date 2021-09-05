package scanner.mihayoo;

public class Main2 {
    public int computeN (int maxValue) {
        int count = count(maxValue);
        return count;
    }

    private int count(int n){
        int res = 0, temp = 1, higher = 0, mid = 0, lower = 0;
        while (n / temp != 0){
            higher = n / (temp * 10);
            mid = (n / temp) % 10;
            lower = n - (n / temp) * temp;
            switch (mid){
                case 0:
                    res += higher * temp;
                    break;
                case 1:
                    res += higher * temp + lower + 1;
                    break;
                default:
                    res += (higher + 1) * temp;
            }
            temp *= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }

}
