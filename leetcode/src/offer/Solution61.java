package offer;

public class Solution61 {
    public boolean isStraight(int[] nums){
        boolean[] t = new boolean[14];
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num == 0){
                continue;
            }
            if (t[num]){
                return false;
            }
            t[num] = true;
            maxVal = Math.max(num, maxVal);
            minVal = Math.min(minVal, num);
        }
        return maxVal - minVal <= 4;
    }
}
