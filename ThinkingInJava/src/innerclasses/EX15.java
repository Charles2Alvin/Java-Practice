package innerclasses;

public class EX15 {
    private int i;
    public EX15(int i) {
        this.i = i;
    }
    public void f(){};

}
class EX152{
    EX15 get15() {
        return new EX15(1){
            @Override
            public void f() {
                super.f();
                System.out.println("Son method");
            }
        };
    }
    EX15 get() {
        return new EX15(2){};
    }
    public static void main(String[] args) {
        EX152 ex152 = new EX152();
        EX15 ex15 = ex152.get15();
        ex15.f();
        EX15 ex151 = ex152.get();
        ex151.f();
    }
}