package hot.sliding_window;

/**
 * Author：yfan.chen
 * Date：2021-09-01 3:44 下午
 **/

/**
 * 字节算法题
 *
 * 最多带有K个不同字符的最长子字符串，注意该题表示子字符串可以有重复字符，但是不同字符的种类必须小于k
 */
public class LengthOfLongestSubstringKDistinct {

    /**
     * （1）还是采用滑动窗口的方法，如果子串中包含有当前字符，就直接添加到子串。
     * （2）如果字串中不包含当前字符，那么需要判断当前字符串字符种类是否大于等于k：
     *
     * 如果大于等于k则移动左边指针，使子串字符种类小于k后，再将当前字符添加进子串。
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k){
        String str = "";
        String ret = "";
        if (s.length() < 1 || k < 1){
            return 0;
        }
        int count = 0, maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (str.contains(Character.toString(s.charAt(i)))){
                str += Character.toString(s.charAt(i));
            } else {
                while (count >= k){
                    String ch = Character.toString(str.charAt(0));
                    str = str.substring(1);
                    if (!str.contains(ch)){
                        count--;
                    }
                }
                str += Character.toString(s.charAt(i));
                count++;
            }
            if (maxLen < str.length()){
                maxLen = str.length();
                ret = str;
            }
        }
        System.out.println(ret);
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "aabbccddeeeeeadddcc";
        int length = new LengthOfLongestSubstringKDistinct().lengthOfLongestSubstringKDistinct(s, 3);
        System.out.println(length);
    }
}
