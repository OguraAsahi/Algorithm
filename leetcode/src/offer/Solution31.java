package offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution31 {

    // 需要一个辅助栈来判断给定的出栈序列是不是众多序列中的一个
    // 每push一次时就循环判断当前栈顶是不是和出栈序列匹配, 若匹配则pop一次堆栈并且让出栈序列下标+1, 继续判断直到栈为空或匹配不上
    // 最后判断辅助栈是否为空即可
    public boolean isPopAndPushEqual(int[] pushed, int[] poped){
        Deque<Integer> s = new ArrayDeque<>();
        int q = 0;
        for (int num : pushed) {
            s.push(num);
            while (!s.isEmpty() && s.peek() == poped[q]){
                s.pop();
                q++;
            }
        }
        return s.isEmpty();
    }

    public static void main(String[] args){
        Solution31 solution31 = new Solution31();
        int[] pushed = {1,2,3,4,5};
        int[] poped = {4,3,2,1,5};
        boolean rs = solution31.isPopAndPushEqual(pushed, poped);
        System.out.println(rs);
    }
}
