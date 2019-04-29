package leetcode;

import java.util.*;

public class lengthOfLongestSubstring {
    /*
    滑窗法：维护两个指针left和right，right指针顺序扫描字符串，判断当前字符是否在集合中；
    如果不在，则将其加入集合，并更新长度，right指针继续右滑，扩大窗口；
    如果在，则在集合中移除left指针对应的元素，并且令left指针右滑，缩小窗口；
    直到right指针遍历完字符串即结束；
    时间复杂度O(n);
     */
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, ans = 0, len = s.length();
        HashSet<Character> set = new HashSet<>();
        while (right < len) {
            char current = s.charAt(right);
            if (!set.contains(current)) {
                set.add(current);
                ans = Math.max(ans, right - left + 1);
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return ans;
    }

    /*
    穷举法：穷举从i(0~n)开始的子串；
    扫描每个子串，将不重复字符加入集合中，并更新长度；
    出现重复字符时，退出循环，扫描下一个子串；
    使用哈希集合来存储可以优化到O(n^2);
     */
    public int lengthOfLongestSubstring2(String s) {
        int length = s.length();
        if (length == 1) return 1;
        int maxLen = 0;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            String sub = s.substring(i);
            for (int j = 0; j < sub.length(); j++) {
                if (!set.add(sub.substring(j,j+1))){
                    maxLen = Math.max(maxLen,set.size());
                    set.clear();
                    break;
                }
            }
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring3(String s) {
        int n = s.length();
        if (n < 2) return n;
        int[] record = new int[128];
        int left = 0;
        int res = 0;
        for (int right = 0; right < n; right++){
            char cur = s.charAt(right);
            // left更新：如果当前字符是重复字符，就把它上次出现的地方作为滑窗的新起点
            if (record[cur] > left){
                left = record[cur];
            }
            // 记录当前字符出现的最新位置
            record[cur] = right + 1;
            // res更新
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "abcabcd";
        lengthOfLongestSubstring l = new lengthOfLongestSubstring();
        System.out.println(l.lengthOfLongestSubstring3(s));
    }

}
