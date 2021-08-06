package sort;

public class MergeSort {
    public static void merge(int[] arr){
        if (arr == null || arr.length == 0){
            System.out.println("数组错误");
            return;
        }
        int len = arr.length;
        int[] result = new int[len];
        int block, start;

        // 原版代码的迭代次数少了一次，没有考虑到奇数列数组的情况
        for(block = 1; block < len*2; block *= 2) {
            for(start = 0; start <len; start += 2 * block) {
                int low = start;
                int mid = Math.min((start + block), len);
                int high = Math.min((start + 2 * block), len);
                //两个块的起始下标及结束下标mid和high
                int start1 = low;
                int start2 = mid;
                //开始对两个block进行归并排序
                while (start1 < mid && start2 < high) {
                    result[low++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
                }
                while(start1 < mid) {
                    result[low++] = arr[start1++];
                }
                while(start2 < high) {
                    result[low++] = arr[start2++];
                }
            }
            int[] temp = arr;
            arr = result;
            result = temp;
        }
        result = arr;
        for (int i = 0; i < len; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int i = 0;
        int[] a = {5,4,9,8,7,6,0,0,1,3,2};
        int[] a1 = {2, 1, 5, 6, 3, 7, 4, 9, 8, 0};
        merge(a1);
    }
}
