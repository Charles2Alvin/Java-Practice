package reusing;

public class EX11 {
    public static void main(String[] args) {
        DetergentDelegation.main(args);
    }
}

class Cleanser {
    private String s = "Cleanser";
    public void append(String a) { s += a; }
    public void dilute() { append(" dilute()"); }
    public void apply() { append(" apply()"); }
    public void scrub() { append(" scrub()"); }
    public String toString() { return s; }
    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute(); x.apply(); x.scrub();
        System.out.print(x);
    }
}

class DetergentDelegation {
    private Cleanser c = new Cleanser();
    public void append(String a) {
        c.append(a);
    }
    public void dilute() {
        c.dilute();
    }
    public void apply() {
        c.apply();
    }
    public void scrub() {
        c.scrub();
    }
    public void foam() {
        c.append(" foam()");
    }
    @Override
    public String toString() {
        return c.toString();
    }
    // Test the new class:
    public static void main(String[] args) {
        DetergentDelegation x = new DetergentDelegation();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        System.out.println(x);
        System.out.print("Testing base class:");
        Cleanser.main(args);
    }
}
