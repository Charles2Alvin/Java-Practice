package reusing.aboutFinal;

public class BlankFinal {
    private final int i;
    private final Dog dog;
    public BlankFinal() {
        this.i = 1;
        this.dog = new Dog("Jacky");
    }
    public static void main(String[] args) {
        BlankFinal f = new BlankFinal();
        //!f.dog = new Dog("Wenwen");

        Dog dog1 = new Dog("Wenwen");
        dog1 = new Dog("Wantao");



        final int i;
        //System.out.println(i);
    }
}
class Dog {
    String name;
    public Dog(String name) {
        this.name = name;
    }
    public void set(final String s) {
        this.name = s;
    }
    final void show() {
        System.out.println(name);
    }
}

class Doggy extends Dog{
    public Doggy(String name) {
        super(name);
    }
    //@Override
    final void sshow() {
        name = "A lovely " + name;
    }
}





