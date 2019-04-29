package holding;
import java.util.*;
/****************** Exercise 7 *****************
 * Create a class and make an initialized array
 * of your class objects. Fill a List from
 * your array. Create a subset of your List using
 * subList(), then remove this subset from
 * your List.
 ***********************************************/
class MyClass {
    private static int counter;
    private int id = counter++;
    public String toString() {
        return "MyClass: "+id;
    }
}

public class EX7 {
    public static void main(String[] args) {
        int N = 10;
        LinkedList<MyClass> list = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            list.add(new MyClass());
        }
        System.out.println("list = " + list);
        List<MyClass> sub = list.subList(0,3);
        System.out.println("sublist = " + sub);
        sub.clear();
        System.out.println("list = " + list);
    }
}
