package innerclasses;
/****************** Exercise 7 *****************
 * Create a class with a private field and a
 * private method. Create an inner class with a
 * method that modifies the outer-class field and
 * calls the outer-class method. In a second
 * outer-class method, create an object of the
 * inner class and call its method, then show
 * the effect on the outer-class object.
 ***********************************************/
public class EX7 {
    private int j = 314;
    private String simpleField;
    private void simpleMethod() {
        System.out.println("The field is "+ simpleField);
        System.out.println("A simple method");
    }

    class Inner {
        private int i = 3;
        void innerMethod() {
            simpleField = "modified by inner class";
            //System.out.println("The field is "+ simpleField);
            simpleMethod();
        }
        private void printInt() {
            j = 222;

            System.out.println("The integer i is "+ i);
            System.out.println("The integer j is "+ j);
        }
    }
    public void create() {
        //simpleMethod();
        Inner inner = new Inner();
        inner.innerMethod();
    }
    public void changeInt() {
        Inner inner = new Inner();
        inner.i = 5;
        inner.printInt();

    }
    public static void main(String[] args) {
        EX7 ex7 = new EX7();
        //ex7.create();
        ex7.changeInt();
    }
}
