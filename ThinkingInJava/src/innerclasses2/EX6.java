package innerclasses2;

import innerclasses.SimpleInterface;
//使用内部类来实现接口，并使这个内部类的构造器public
public class EX6 {
    protected class SmallParcel implements SimpleInterface {
        //force the constructor to be public
        public SmallParcel() {
            System.out.println("Inner Class Constructor");
        }
        @Override
        public void f() {
            System.out.println("f");
        }
    }

}
