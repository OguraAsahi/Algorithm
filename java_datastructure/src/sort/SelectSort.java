package sort;

public class SelectSort {
    /**
     * 选择排序, 即每一轮外循环都选出最大或最小的数, 直到所有数有序
     * @param a
     */
    public static void selectSort(int[] a){
        if (a == null){
            System.out.println("数组错误");
            return;
        }
        int i, j;
        int temp = 0, flag = 0;
        int n = a.length;
        for (i = 0; i < n; i++) {
            temp = a[i];
            flag = i;
            for (j = i + 1; j < n; j++) {
                // temp选择较小的那个数, flag标记较小的那个数
                if (a[j] < temp){
                    temp = a[j];
                    flag = j;
                }
            }
            if (flag != i){
                a[flag] = a[i];
                a[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int i = 0;
        int[] a = {5,4,9,8,7,6,0,1,3,2};
        selectSort(a);
        for (i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
