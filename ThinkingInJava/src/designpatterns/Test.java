package designpatterns;

public class Test {
    public static int add(int a, int b) {
        try {
            return a + b;
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }
        return 0;
    }
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operator(a, b);
        System.out.println(a+", "+b);
        System.out.println("sum is "+add(4, 5));
    }
    public static void operator(StringBuffer x, StringBuffer y) {
        x.append(y);
        y = x;

    }
}
