package offer;

public class NumberOf1 {
    public int NumberOf1(int n) {
        int count = 0, op = 1;
        while (op != 0) {
            if ((n & op) != 0)
                count++;
            op = op << 1;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(1 << 31);
    }
}
