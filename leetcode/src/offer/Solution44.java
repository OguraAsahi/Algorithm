package offer;

/**
 * 数字以 0123456789101112131415…的格式序列化到一个字符序列中。
 *
 * 在这个序列中，第 5 位（从下标 0 开始计数）是 5，第 13 位是 1，第 19 位是 4，等等。
 *
 * 请写一个函数，求任意第 n 位对应的数字。
 */
public class Solution44 {

    //先求出第 n 位所在的 pow 和真实数字，进而求出真实数字的第 n % (pow + 1) 位即可。
    public int findNthDigit(int n){
        if (n < 10){
            return n;
        }
        int pow = 0, count;
        while (true){
            count = getBitNum(pow);
            if (n < count){
                break;
            }
            // 减去0~9, 10~99,.....得到第 n 位真实所在的分区
            n -= count;
            ++pow;
        }
        // 由100, 101, 102, 103, ...得出规律
        // 先求出对应的那个数字为n / (pow + 1) + (int) Math.pow(10, pow)
        int num = n / (pow + 1) + (int) Math.pow(10, pow);
        // 然后根据数字num求出该数字的第 n 位实际是什么, 实际为num的第n % (pow + 1)位数
        return String.valueOf(num).charAt(n % (pow + 1)) - '0';
    }

    public int getBitNum(int pow){
        if (pow == 0){
            return 10;
        }
        //pow = 0：0~9 有 10 位
        //pow = 1: 10~99 有 90*2=180 位
        //pow = 2: 100~999 有 900*3=2700 位。
        return (int)(9 * Math.pow(10, pow) * (pow + 1));
    }

    public static void main(String[] args) {
        int digit = new Solution44().findNthDigit(193);
        System.out.println(digit);
    }
}
