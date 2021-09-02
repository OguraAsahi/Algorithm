package hot.sliding_window;

/**
 * Author：yfan.chen
 * Date：2021-09-01 3:45 下午
 **/

/**
 * 最多带有K个不同字符的最长子字符串，子字符串不能含有重复字符
 *
 * 输入：5 ，“leetcode” 输出：5—“tcode”
 */
public class KSubstring {
    /**
     * 解题步骤：
     *
     * 采用窗口长度可变的滑动窗口法。先让一个指针指向最左边i=0，依次移动右边指针至i=s.length()。
     *
     * 如果当前字符不包含在子字符串，则将该字符添加进子字符串。反之，如果子串包含该字符，左边指针依次向右移动，直至子串不包含该字符，再移动右边指针。
     */

    public int kSubstring(String s, int k){
        String sub = "";
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            while(sub.contains(Character.toString(s.charAt(i)))) {
                sub = sub.substring(1);
            }
            sub += Character.toString(s.charAt(i));
            if(sub.length() <= k)
                maxLen = Math.max(maxLen, sub.length());
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int ret = new KSubstring().kSubstring("abccdefd", 5);
        System.out.println(ret);
    }

}
