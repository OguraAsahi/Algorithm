package lab3;
import java.util.Arrays;
public class Tools {
    public static boolean useList(Integer[] arr, Integer targetValue) {
        // asList返回一个受指定数组支持的固定大小的列表
        return Arrays.asList(arr).contains(targetValue);

    }

    public static int exchange(Integer[] array, Integer[] phy, int n) {

        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            //赋值给相应的物理块标记数组，后续不存在即为-1
            b[i] = Arrays.asList(array).indexOf(phy[i]);
            if (b[i] == -1) {
                return i;
            }
        }
        for (int j = 0; j < n; j++) {
            for (int g = 0; g < n; g++) {
                if (g == n - 1 && b[j] >= b[n - 1]) {
                    return j;
                }
                if (b[j] >= b[g]) {
                    continue;
                } else {
                    break;
                }
            }
        }
        return 0;
    }
}
