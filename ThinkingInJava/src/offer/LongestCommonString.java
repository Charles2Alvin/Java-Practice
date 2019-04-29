package offer;

public class LongestCommonString {
    String a = "eCOOLn", b = "pCOOLp";
    int[][] c = new int[a.length()][b.length()];
    public String LCS() {
        int endOfLCS = 0, maxlen = 0;
        int n = a.length(), m = b.length();
        for (int i = 0; i < n; i++)
            c[i][0] = 0;
        for (int i = 0; i < m; i++)
            c[0][i] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                } else {
                    c[i][j] = 0;
                }
                if (c[i][j] > maxlen) {
                    maxlen = c[i][j];
                    endOfLCS = j;
                }
            }
        }
        return a.substring(endOfLCS-maxlen, endOfLCS);
    }
    public static void main(String[] args) {
        LongestCommonString lcs = new LongestCommonString();
        System.out.println(lcs.LCS());
        LongestCommonSubsequence.print(lcs.c);
    }
}
