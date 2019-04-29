package innerclasses;
/****************** Exercise 12 *****************
 * Repeat Exercise 7 using an anonymous inner
 * class.
 ***********************************************/
/****************** Exercise 7 *****************
 * Create a class with a private field and a
 * private method. Create an inner class with a
 * method that modifies the outer-class field and
 * calls the outer-class method. In a second
 * outer-class method, create an object of the
 * inner class and call its method, then show
 * the effect on the outer-class object.
 ***********************************************/
public class EX12 {
    private String simpleField;
    private void simpleMethod() {
        System.out.println("The field is "+ simpleField);
        System.out.println("A simple method");
    }
    //创建内部类来修改外部类的私有变量，调用私有方法
    public void create() {
        //使用匿名类使代码更加简洁优雅
        new Object() {
            private int i = 3;
            void innerMethod() {
                simpleField = "modified by inner class";
                //System.out.println("The field is "+ simpleField);
                simpleMethod();
            }
            private void printInt() {
                System.out.println("The integer is "+ i);
            }
        }.innerMethod();
    }
    public static void main(String[] args) {
        EX7 ex7 = new EX7();
        ex7.create();
        //ex7.changeInt();
    }
}
