package holding;
import java.util.*;
/****************** Exercise 8 ******************
 * Modify Exercise 1 so it uses an Iterator to
 * move through the List while calling hop().
 ***********************************************/
public class EX8 {
    public static void main(String[] args) {
        int N = 10;
        LinkedList<Gerbil> list = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            list.add(new Gerbil(i));
        }
        //Iterator统一了对容器的访问方式，将遍历序列的操作与底层的结构分离；
        for (Iterator<Gerbil> iterator = list.iterator();
            iterator.hasNext();
            iterator.next().hop());
    }

}
