package hot.array;

public class SmallestNumInSpinArray {
    public int minArray(int[] arr){
        int l = 0, r = arr.length - 1;
        while (l < r){
            int m = (l + r) >>> 1;
            if (arr[m] > arr[r]){
                l = m + 1;
            } else if (arr[m] < arr[r]){
                r = m;
            } else {
                --r;
            }
        }
        return arr[l];
    }
}
