package offer;

public class replaceSpace {
    public String replaceSpace(StringBuffer str) {
        int n = str.length();
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == ' ') {
                s.append("%20");
            } else s.append(str.charAt(i));
        }
        return s.toString();
    }
    public static void main(String[] args) {
        System.out.println(new replaceSpace().replaceSpace(new StringBuffer("We%20Are%20Happy")));
    }
}
