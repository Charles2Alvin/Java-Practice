//: reusing/E21_FinalMethod.java
// {CompileTimeError}
/****************** Exercise 21 ****************
 * Create a class with a final method. Inherit
 * from that class and attempt to override that
 * method.
 ***********************************************/

package reusing;

class WithFinalMethod {
    static final void f() {
        System.out.println("f");
    }
}
public class E21_FinalMethod extends WithFinalMethod {
    static void f(int i) {
        System.out.println("f i");
    }
    public static void main(String args[]) {
        f();
    }
} ///:~