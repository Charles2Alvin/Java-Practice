package offer;

public class LongestCommonSubsequence {
    String a = "eCOsOqqLnani", b = "rCOOwpwpLp";
    int[][] c = new int[a.length()][b.length()];
    /**
     * @param a
     * @param b
     * 递归方法求解，无非有三种情况：
     * 1）a、b长度为-1，返回""；
     * 2）a[n-1] = b[m-1]，即尾字符相等，问题减少为LCS(a[:n-1],b[:n-1])
     * 3）a[n-1] != b[m-1]，取LCS(a,b[:n-1])和LCS(a[:n-1],b)的较大者
     * 只能求出长度
     * @return
     */
    public String LCS(String a, String b) {
        int n = a.length(), m = b.length();
        if (n <= 0 || m <= 0) return "";
        if (a.charAt(n - 1) == b.charAt(m - 1))
            return LCS(a.substring(0,n - 1), b.substring(0,m - 1)) + a.charAt(n - 1);
        String left = LCS(a, b.substring(0, m - 1));
        String right = LCS(a.substring(0, n - 1), b);
        return left.length() > right.length() ? left : right;
    }

    /**
     * 迭代法，同样也有三种情况；
     * c[i][j] = 0, i = 0 or j = 0
     * c[i][j] = c[i-1][j-1], x[i] == y[j]
     * c[i][j] = max(c[i][j-1], c[i-1][j]), x[i] != y[j]
     * 那么就可以开始填表了
     * 最重要的是理解c[i][j]的意义：
     * c[i][j] = length of LCS of Xi and Yj
     * @return
     */
    public String LCS2() {
        int n = a.length(), m = b.length();
        c = new int[n][m];
        //初始化记录表，第0行和第0列为全0
        for (int i = 0; i < n; i++)
            c[i][0] = 0;
        for (int i = 0; i < m; i++)
            c[0][i] = 0;
        //开始填表，c[i][j] = a[:i]和b[:j]的LCS的长度
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (a.charAt(i) == b.charAt(j)){
                    c[i][j] = c[i-1][j-1]+1;
                } else if (c[i][j-1] < c[i-1][j]){
                    c[i][j] = c[i-1][j];
                } else {
                    c[i][j] = c[i][j-1];
                }
            }
        }
        StringBuffer s = new StringBuffer();
        while (n >= 1 && m >= 1) {
            if (a.charAt(n - 1) == b.charAt(m - 1)) {
                s.append(a.charAt(n - 1));
                m--;
                n--;
            } else if (n >= 2 && m >= 2) {
                if (c[n - 1][m - 2] > c[n - 2][m - 1]) {
                    m--;
                } else n--;
            }
            //假如 m = 1 or n = 1，说明已经到了边界，没有左上角或者右上角了
            else break;
        }
        return s.reverse().toString();
    }
    public static void print(int[][] c) {
        int n = c.length, m = c[0].length;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                System.out.print(c[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println("Answer: "+lcs.LCS2());
    }
}
