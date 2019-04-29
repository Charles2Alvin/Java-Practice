package innerclasses;
/****************** Exercise 23 *****************
 * Create an interface U with three methods.
 * Create a class A with a method that produces a
 * reference to a U by building an anonymous
 * inner class. Create a second class B that
 * contains an array of U. B should have one
 * method that accepts and stores a reference to
 * a U in the array, a second method that sets a
 * reference in the array (specified by the
 * method argument) to null, and a third method
 * that moves through the array and calls the
 * methods in U. In main(), create a group of A
 * objects and a single B. Fill the B with U
 * references produced by the A objects. Use the
 * B to call back into all the A objects. Remove
 * some of the U references from the B.
 ***********************************************/
interface U {
    void f1();
    void f2();
    void f3();
}
class A {
    private int i;
    public A(int i) {
        this.i = i;
    }
    U makeU(){
        return new U() {
            @Override
            public void f1() {
                System.out.println("U::f1");
            }
            @Override
            public void f2() {
                System.out.println("U::f2");
            }
            @Override
            public void f3() {
                System.out.println("U::f3");
            }

            @Override
            public String toString() {
                return "U$classname{A} "+i;
            }
        };
    }
}

class B {
    //num为数组里已经填入的元素个数
    int num;
    U[] arrayOfU;
    public B(int size) {
        arrayOfU = new U[size];
        //System.out.println(arrayOfU.length);
    }
    boolean add(U u) {
        if (num < arrayOfU.length) {
            arrayOfU[num++] = u;
            return true;
        }
        return false;
    }
    boolean setNull(int index) {
        if (index < 0 || index >= arrayOfU.length) {
            return false;
        }
        arrayOfU[index] = null;
        return true;
    }
    void traverse() {
        for (U each : arrayOfU) {
            if (each == null)
                continue;
            System.out.println(each);
            each.f1();
            each.f2();
            each.f3();
        }
    }
}

public class EX23 {
    public static void main(String[] args) {
        int N = 5, i = 0;
        B b = new B(N);
        A[] arrayOfA = new A[N];
        for (A a : arrayOfA) {
            a = new A(i++);
            b.add(a.makeU());
        }
        b.traverse();
        System.out.println("*****");
        b.setNull(2);
        b.traverse();

    }
}
