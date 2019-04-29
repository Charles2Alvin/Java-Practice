///:Main.java
import com.sun.jdi.event.ThreadDeathEvent;

import java.io.IOException;
import java.util.*;

/** The first example program
 * List system information on current machine
 * Chapter 9: Interface.Exercise 4
 * @author  Alvin MO
 * @version 1.0
 */
abstract class Fruit {
    String Name;
    Fruit() {
        eat();
    }
    void eat() {
        System.out.println("fruit");
    }
}
abstract class Food {
    String foodName = "food";
    abstract void print();
}
class Eatable extends Food {
    void print() {
        System.out.println("eatable");
    }
}
class Apple extends Fruit {
    int num = 1;
    void eat() {
        System.out.println(num+" apple");
    }
}
interface Tools{
    int num = 1;
    void print();
    void use();
}
class Pencil implements Tools {
    public void print() {
        System.out.println("a pencil");
    }

    @Override
    public void use() {
        System.out.println("use pencil");
    }
}
public class Main {
    /**
     * This method demonstrates square().
     * @param args Unused.
     * @deprecated  the image at the specified URL.
     * @see         String
     */
    public static void main(String[] args) {
        Pencil p = new Pencil();
        speak(new Eatable());
        System.out.println("Main");
    }///:~
    static void speak(Food f) {
        f.print();
    }

}