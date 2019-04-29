package holding;
/****************** Exercise 2 ******************
 * Modify SimpleCollection.java to use a Set for c.
 ***********************************************/
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class EX2 {
    public static void main(String[] args) {
        Collection<Integer> c = new HashSet<>();
        int N = 10;
        for (int i = 0; i < N; i++) {
            c.add(i);
        }
        for (int i : c){
            System.out.print(i+" ,");
        }
    }
}
