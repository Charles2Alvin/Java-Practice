package innerclasses;
/****************** Exercise 26 *****************
 * Create a class with an inner class that has a
 * non-default constructor (one that takes
 * arguments). Create a second class with an inner
 * class that inherits from the first inner class.
 ************************************************/
class WithInner {
    class Inner {
        private int i = 0;
        public Inner(int i) {
            this.i = i;
        }
        void f() {
            System.out.println("Inner::f()");
        }
    }
}

public class EX26 {
    class Inner1 extends WithInner.Inner {
        public Inner1(WithInner withInner, int i) {
            withInner.super(i);
        }
        void f() {
            System.out.println("Inner1::f()");
            super.f();
        }
    }
    public static void main(String[] args) {
        WithInner withInner = new WithInner();
        //WithInner.Inner inner = withInner.new Inner(1);
        EX26 e = new EX26();
        Inner1 inner1 = e.new Inner1(withInner, 1);
        inner1.f();

    }
}
