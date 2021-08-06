package sort;

public class BubbleSort {
    /**
     * 冒泡排序:
     * 每经过一轮外循环, 当前最大的一个数(最大的气泡)就会冒出到水面上
     * 每经过一轮内循环, 就会对相邻的两个数进行比较
     * @param a
     */
    public static void bubbleSort(int[] a){
        int i, j;
        int temp, len = a.length;
        for (i = 0; i < len - 1; i++) {
            for (j = 0; j < len - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int i = 0;
        int[] a = {5,4,9,8,7,6,0,0,1,3,2};
        bubbleSort(a);
        for (i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
