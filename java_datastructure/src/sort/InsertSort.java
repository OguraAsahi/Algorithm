package sort;

public class InsertSort {
    /**
     * 插入排序类似于我们打扑克牌时, 拿到第一张牌后, 根据第二张牌的大小插入到第一张牌的左边或者右边, 直到所有牌拿完
     * 每经过一次外循环, 就相当于抽一次牌并且将牌放到对应的位置
     * 每经过一次内循环, 就相当于从右边开始判断要不要插入, 不要插入则会把比较的牌向右移一位, 要插入则会退出内循环并且插入
     * @param a
     */
    public static void insertSort(int[] a){
        if (a != null){
            for (int i = 1; i < a.length; i++) {
                int temp = a[i];
                int j = i;
                // 对左边相邻的牌一一进行比较, 若左边的大一些则把它向右移一位
                while (j >= 1 && a[j - 1] > temp){
                    a[j] = a[j - 1];
                    j--;
                }
                // 当左边的牌比要插入的牌小的时候, 就可以进行插入了
                a[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int i = 0;
        int[] a = {5,4,9,8,7,6,0,0,1,3,2};
        insertSort(a);
        for (i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
