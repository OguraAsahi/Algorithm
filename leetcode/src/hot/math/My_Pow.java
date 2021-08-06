package hot.math;

public class My_Pow {
    public double my_Pow(double m, int n){
        if (n == 0){
            return 1;
        }
        if (n == 1){
            return m;
        }
        if (n == -1){
            return 1 / m;
        }
        double half = my_Pow(m, n / 2);
        return half * half * my_Pow(m, n % 2);
    }
}
