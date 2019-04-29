package initialization;

public class EX17 {
    static {
        System.out.println("Static block");
    }
    static void cool() {
        System.out.println("cool()");
    }
    public EX17() {
        System.out.println("Constructor");
    }
    public EX17(String msg) {
        System.out.println("Constructor");
        System.out.println(msg);
    }
    public static void main(String[] args) {
        EX17[] e = new EX17[10];
//        for (int i = 0; i < 10; i++) {
//            e[i] = new EX17("hi");
//        }
        for (EX17 each : e) {
            each = new EX17("wow");
        }

    }
}
