package reusing;

public class EX15 {
    protected void f(int i) {
        System.out.println("void f()");
    }
    void e() {
        System.out.println("void e()");
    }
    int e(int i) {
        System.out.println("void e(int i)");
        return i;
    }
}
class test{
    public static void main(String[] args) {
        float i = 0;
        long j = 0;
        EX15 e = new EX15();
        e.f((int) j);
    }
}
//: reusing/protect/E15_Protected.java
/****************** Exercise 15 *****************
 * Create a class with a protected method inside
 * a package. Try to call the protected method
 * outside the package, and explain the results.
 * Now inherit from your class and call the
 * protected method from inside a method of your
 * derived class.
 ***********************************************/
/*

package reusing.protect;
public class E15_Protected {
    protected void f() {}
} ///:~
//: reusing/E15_ProtectedTest.java

package reusing;
import reusing.protect.*;
class Derived extends E15_Protected {
    public void g() {
        f(); // Accessible in derived class
    }
}
public class E15_ProtectedTest {
    public static void main(String args[]) {
    //! new E15_Protected().f(); // Cannot access
             new Derived().g();
           }
} ///:~
*/