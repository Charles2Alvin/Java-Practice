package innerclasses;

import java.util.Formatter;
/****************** Exercise 21 ******************
 * Create an interface with a nested class
 * and a static method that calls the methods
 * of your interface and displays the results.
 * Implement your interface and pass an instance of
 * your implementation to the method.
 ***********************************************/
/****************** Exercise 20 *****************
 * Create an interface containing a nested class.
 * Implement this interface and create an
 * instance of the nested class.
 ***********************************************/
interface SimpleOne {
    void g();
    class Nested{
        static void call(SimpleOne simpleOne) {
            simpleOne.g();
            System.out.println("Nested: f()");
        }
    }
}
public class EX20 {
    public static void main(String[] args) {
        SimpleOne.Nested.call(new SimpleOne() {
            @Override
            public void g() {
                System.out.println("Interface::g()");
            }
        });

    }

}