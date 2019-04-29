package innerclasses;

import javax.lang.model.type.PrimitiveType;

public class EX1 {
    class Packet {
        String name;
        public Packet(String name) {
            this.name = name;
        }
    }
    Packet makeOne(String name) {
        return new Packet(name);
    }
    static Packet sMakeOne(String name) {
        EX1 ex1 = new EX1();
        Packet p = ex1.makeOne(name);
        return ex1.makeOne(name);
    }
    void makeInner() {
        Outer outer = new Outer("hi");
        Outer.Inner i = outer.new Inner();
    }
    public static void main(String[] args) {
        Outer outer = new Outer("hi");
        Outer.Inner i = outer.getInner();
    }

}
class Outer{
    private String s;

    public Outer(String s) {
        this.s = s;
    }

    class Inner{
        public Inner() {
        }
        @Override
        public String toString() {
            return s;
        }
    }
    Inner getInner() {
        return new Inner();
    }
    public static void main(String[] args) {
        Outer outer = new Outer("hi");
        Inner i = outer.getInner();
    }
}