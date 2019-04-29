package initialization;

public class EX3 {
    public EX3() {
        System.out.println("EX3 constructor");
    }
    public EX3(int i) {
        System.out.println("EX3(int i)");
    }
    public static void main(String[] args) {
        EX3 e1 = new EX3();
        EX3 e2 = new EX3(1);
    }
}
class Dog{
    void bark(int i) {
        System.out.println("bark(int i)");
    }
    void bark(double i) {
        System.out.println("bark(double i)");
    }
    void bark(float i) {
        System.out.println("bark(float i)");
    }
    void bark(long i) {
        System.out.println("bark(long i)");
    }

    void bark(long i, int j) {
        System.out.println("bark(long i, int j)");
    }
    void bark(int i, long j) {
        System.out.println("bark(int i, long j)");
    }
    void f() {
        System.out.println("f()");
        g();
        this.g();
    }
    void g() {
        System.out.println("g()");
    }
    public static void main(String[] args) {
        short num = 0;
        EX3 e1 = new EX3();
        EX3 e2 = new EX3(1);
        Dog dog = new Dog();
        dog.bark((int) num);
        dog.bark((double) num);
        dog.bark((float) num);
        dog.bark((long) num);
        dog.bark((long) num, (int) num);
        dog.bark((int) num, (long) num);
        dog.f();

    }
}