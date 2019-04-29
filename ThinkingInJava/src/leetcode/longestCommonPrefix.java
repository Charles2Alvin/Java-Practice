package leetcode;

public class longestCommonPrefix {
    /*
    剪尾法：任意假定一个字符串s是所有串的最长公共子串，遍历字符串数组；
    扫描到当前字符串cur时，假如它不是以s开头的（用startWith()方法判断），
    去掉s最后一个元素，直到cur的确是以s开头的；
    由于s的长度是常数，这样的检测花费O(1)时间；
    整体时间复杂度取决于while循环会执行几次，由于s是定长的，它能被裁剪的次数最多是s.length()；
    最终花费O(n)时间；
     */
    public String longestCommonPrefix2(String[] strs) {
        int length = strs.length;
        if (length == 0) return "";
        String pre = strs[0];
        for(int i = 1; i < length; i++){
            while (!strs[i].startsWith(pre)) {
                int len = pre.length();
                if (len >0)
                pre = pre.substring(0, pre.length() - 1);
                System.out.println(pre+" "+strs[i]);
            }
        }
        return pre;
    }
    /*
    分治法
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }
    //把字符串数组分成左半和右半，返回这两个整体的公共前缀
    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            System.out.println(strs[l]);
            return strs[l];
        }
        int mid = (l + r) / 2;
        String left = longestCommonPrefix(strs, l, mid);
        String right = longestCommonPrefix(strs, mid + 1, r);
        return commonPrefix(left, right);
    }
    //顺序遍历，返回left和right的公共前缀，时间O(n)
    private String commonPrefix(String left,String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }
    public static void main(String[] args) {
        longestCommonPrefix lcp = new longestCommonPrefix();
        String[] strs = new String[]{"flowers","flow","fly"};
        System.out.println("Result: "+lcp.longestCommonPrefix(strs));
    }
}
