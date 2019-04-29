package innerclasses;

public class EX3 {
    public static void main(String[] args) {
        Outer outer = new Outer("wow");
        Outer.Inner i = outer.new Inner();
        System.out.println(i);
    }
}
