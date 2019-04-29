package holding;
/****************** Exercise 1 ******************
 * Create a new class called Gerbil with an int
 * gerbilNumber initialized in the constructor.
 * Give it a method called hop() that prints out
 * which gerbil number this is, and that it’s hopping.
 * Create an ArrayList and add Gerbil objects to
 * the List. Now use the get() method to move
 * through the List and call hop() for each Gerbil.
 ***********************************************/
import java.util.ArrayList;

class Gerbil {
    private int gerbilNumber;
    public Gerbil(int gerbilNumber) {
        this.gerbilNumber = gerbilNumber;
    }

    @Override
    public String toString() {
        return "Gerbil " + gerbilNumber;
    }

    void hop() {
        System.out.println(this+" is hopping");
    }
}

public class EX1 {
    public static void main(String[] args) {
        int N = 10;
        ArrayList<Gerbil> a = new ArrayList(10);
        for (int i = 0; i < N; i++) {
            a.add(new Gerbil(i));
        }
        for (Gerbil g : a) {
            g.hop();
        }
    }
}
