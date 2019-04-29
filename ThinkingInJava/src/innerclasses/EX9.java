package innerclasses;
/****************** Exercise 9 *****************
 * Create an interface with at least one method,
 * and implement it by defining an
 * inner class within a method that returns a
 * reference to your interface.
 ***********************************************/
public class EX9 {
    //在方法内部，定义内部类并实现接口，并返回这个内部类的引用
    SecondInterface define() {
        class Inner implements SecondInterface {
            @Override
            public void SimpleMethod() {
                System.out.println("Cool!--from Inner");
            }
        }
        return new Inner();
    }
    public static void main(String[] args) {
        EX9 ex9 = new EX9();
        SecondInterface s = ex9.define();
        s.SimpleMethod();
    }
}
