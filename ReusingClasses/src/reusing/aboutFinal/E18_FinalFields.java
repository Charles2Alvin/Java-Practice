package reusing.aboutFinal;

//: reusing/E18_FinalFields.java
/****************** Exercise 18 *****************
 * Create a class with a static final field and a
 * final field and demonstrate the difference
 * between the two.
 ***********************************************/

class SelfCounter {
    public static int count;
    public int id = count++;
    public String name;

    public SelfCounter(String name) {
        this.name = name;
        System.out.println("Making a SelfCounter!");
        System.out.println(count);
        System.out.println(id);
    }

    public String toString() { return " SelfCounter " + id; }
}
class WithFinalFields {
    final SelfCounter scf = new SelfCounter("scf");
    static final SelfCounter scsf = new SelfCounter("scsf");

    public WithFinalFields() {
        System.out.println("Making a WithFinalFields!");
        System.out.println(scf.id);
        System.out.println(scsf.id);
    }

    public String toString() {
        return "scf = " + scf + " scsf = " + scsf;
    }
}
public class E18_FinalFields {
    public static void main(String args[]) {
        System.out.println("First object:");
        System.out.println(new WithFinalFields());
        System.out.println("Second object:");
        System.out.println(new WithFinalFields());
    }
} /* Output:
         First object:
         scf = SelfCounter 1
         scsf = SelfCounter 0
         Second object:
         scf = SelfCounter 2
         scsf = SelfCounter 0
         *///:~
