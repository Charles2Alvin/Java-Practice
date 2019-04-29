package innerclasses;
/****************** Exercise 19 *****************
 * Create a class containing an inner class that
 * itself contains an inner class. Repeat this
 * using static inner classes. Note the names of
 * the .class files produced by the compiler.
 ***********************************************/
public class EX19 {
    static class Nested1 {
        public Nested1() {
            System.out.println("static class Nested 1");
        }

        static class Nested2 {
            public Nested2() {
                System.out.println("static class Nested 2");
            }
        }
    }
    class Inner1 {
        Inner2 makeI2() {
            return new Inner2();
        }
        class Inner2{
        }
    }
    Inner1 makeI1() {
        return new Inner1();
    }
    void f() {
        Inner1 hh = new Inner1();
        EX19 ex19 = new EX19();
        EX19.Inner1 ei1 = ex19.new Inner1();
    }
    public static void main(String[] args) {
        Nested1 n1 = new Nested1();
        Nested1.Nested2 n2 = new Nested1.Nested2();
        EX19 ex19 = new EX19();
        Inner1 inner1 = ex19.makeI1();
        Inner1.Inner2 inner2 = inner1.makeI2();
        //inner1 =
        EX19.Inner1 ei1 = ex19.new Inner1();

    }
}
class OtherClass {
    void f() {
        EX19 ex19 = new EX19();
        EX19.Inner1 inner2 = ex19.makeI1();
        EX19.Inner1 inner1 = ex19.new Inner1();
    }
    static void g() {
        EX19 ex19 = new EX19();
        EX19.Inner1 inner1 = ex19.makeI1();
        EX19.Inner1.Inner2 inner2 = inner1.makeI2();
        //inner1 =
        EX19.Inner1 ei1 = ex19.new Inner1();

    }
}