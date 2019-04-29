package offer;

public class Fibonacci {
    /**
     * 迭代法；维护f和g始终为相邻的一对斐波那契数
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        int f = 0, g = 1;
        while (n-- > 0) {
            //g是下一项，更新方法是当前项和前一项的和
            g = g + f;
            //也就是f的值更新为g的旧值
            f = g - f;
        }
        return f;
    }
}
