package leetcode;
public class titleToNumber {
    /*
    相当于26进制转10进制；
     */
    public int titleToNumber(String s) {
        int sum = 0;
        for (char aChar : s.toCharArray())
            sum = sum*26 + aChar - 'A' + 1;
        return sum;
    }
}
