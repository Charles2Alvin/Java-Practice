package leetcode;

import java.util.*;

public class checkInclusion {
    /*
    滑窗法：由于字符串太长，不可能穷举所有的排列；
    转而关注s1的字符种类和出现的次数；
    用一个长度等于len(s1)的滑窗，在s2上滑动，统计窗内元素的种类和出现次数；
    如果与s1相同，那么s2包含s1的排列
     */
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length(),l2 = s2.length();
        int[] c1 = new int[26], c2 = new int[26];
        //相对定位的方法：由于26个字母从a开始，减去a的ASCII值就是该字母在alphabet的索引
        for(char c : s1.toCharArray())
            c1[c-'a']++;
        //在s2上滑窗，维护窗内元素的记录
        for(int i = 0; i < l2; i++)
        {
            //遍历长度超过滑窗的size时，更新离开滑窗的元素的出现次数
            if(i >= l1)
                c2[s2.charAt(i-l1)-'a']--;//先把坐标查过的
            //新字符记录到滑窗中
            c2[s2.charAt(i)-'a']++;
            if(Arrays.equals(c1, c2))
                return true;
        }
        return false;
    }
    public boolean checkInclusion2(String s1, String s2) {
        //先转成字符数组
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        //将s1存在哈希表里
        HashMap<Character,Integer> map = new HashMap<>();
        for (char c : c1) {
            if (!map.containsKey(c))
                map.put(c,1);
            else
                map.put(c,map.get(c)+1);
        }
        //遍历s2，当前字符存在于set时，截取后面一段，再加入集合，比较两个集合是否相等
        int len1 = c1.length, len2 = c2.length;
        for (int i = 0; i < len2; i++) {
            if (map.containsKey(c2[i])) {
                char[] sub = Arrays.copyOfRange(c2, i,i+len1);
                HashMap<Character, Integer> tmp = new HashMap<>();
                for (char c : sub) {
                    if (!tmp.containsKey(c))
                        tmp.put(c,1);
                    else
                        tmp.put(c,tmp.get(c)+1);
                }
                if (map.equals(tmp)){
                    System.out.println(sub+" "+tmp);
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String s1 = "hello", s2 = "ooolleoooleh";
        checkInclusion c = new checkInclusion();
        System.out.println(c.checkInclusion(s1, s2));
    }
}
