package innerclasses;
/****************** Exercise 13 *****************
 * Repeat Exercise 9 using an anonymous inner
 * class.
 ***********************************************/
/****************** Exercise 9 *****************
 * Create an interface with at least one method,
 * and implement it by defining an
 * inner class within a method that returns a
 * reference to your interface.
 ***********************************************/
public class EX13 {
    //在方法内部，定义内部类并实现接口，并返回这个内部类的引用
    public SecondInterface define() {
        return new SecondInterface() {
            @Override
            public void SimpleMethod() {
                System.out.println("EX13--Anonymous class");
            }
        };
    }
    public static void main(String[] args) {
        EX13 ex13 = new EX13();
        SecondInterface s = ex13.define();
        s.SimpleMethod();
    }
}