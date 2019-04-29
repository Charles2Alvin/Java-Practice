package innerclasses;
/****************** Exercise 18 *****************
 * Create a class containing a nested class.
 * In main(), create an instance of the nested
 * class.
 ************************************************/
public class EX18 {
    static class Inner18 {
        void f() {}
    }
    public static void main(String[] args) {
        Inner18 inner18 = new Inner18();
    }
}
// Specifying the nested type outside
// the scope of the class:
class Other {
    public static void main(String[] args) {
        EX18.Inner18 inner18 = new EX18.Inner18();
    }
}
