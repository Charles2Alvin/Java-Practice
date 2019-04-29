package innerclasses;

class Outer11 {
    private class Inner implements SecondInterface{
        @Override
        public void SimpleMethod() {
            System.out.println("Private inner class");
        }
    }
    Inner get() {
        return new Inner();
    }
    SecondInterface getInner() {
        return new Inner();
    }
}
public class EX11 {
    public static void main(String[] args) {
        Outer11 outer11 = new Outer11();
        SecondInterface si = outer11.getInner();
        si = outer11.get();
        si.SimpleMethod();
        //不能向下转型：inner不可见
        //! Inner inr = outer11.getInner();
        //! Inner inr2 = (Inner) si;
    }
}