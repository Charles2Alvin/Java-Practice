package exceptions;
/****************** Exercise 2 ******************
 * Define an object reference and initialize it
 * to null. Try to call a method through this
 * reference. Now wrap the code in a try-catch
 * clause to catch the exception.
 ***********************************************/
class TestDrive {
    void f() {}
}
public class EX2 {
    public static void main(String[] args) {
        try {
            TestDrive t = null;
            t.f();
        }catch (Exception e) {
            System.out.println("Caught");
            System.out.println(e);
        }
    }
}
