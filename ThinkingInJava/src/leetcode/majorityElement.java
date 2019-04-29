package leetcode;

import java.util.*;
public class majorityElement {
    /*
    找众数（出现次数大于n/2），属于1/k数问题，用摩尔投票法解决；
    假设第一个元素就是众数，即candidate；
    遍历数组，假如当前元素与candidate相同，计数器++；
    假如不一样：
    如果计数器为0，令当前元素为新的candidate，计数器++；
    否则，counter--；
    推广的1/k问题，就用k个candidate和k个计数器解决；
     */
    public int majorityElement(int[] nums) {
        int candidate = nums[0], counter = 0;
        for (int num : nums) {
            if (num == candidate) counter++;
            else if (counter == 0) {
                candidate = num;
                counter++;
            } else counter--;
        }
        return candidate;
    }
    public int majorityElement2(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num)+1);
            else
                map.put(num, 0);
        }
        int maxNum, maxTimes, length = nums.length;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > length/2-1){
                return entry.getKey();
            }
        }
        return 0;
    }
}