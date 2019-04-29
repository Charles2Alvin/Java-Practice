package holding;

import java.util.*;

public class EX4 {
}
class Generator {
    int index = 0;
    String[] names = {"The avengers", "Iron Man", "Captain America",
    "Thor", "X-Men", "Captain Marvel"};
    int length = names.length;
    String next() {
        index = index % (length);
        return names[index++];
    }
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        LinkedList<String> l = new LinkedList<>();
        HashSet<String> h = new HashSet<>();
        LinkedHashSet<String> ls = new LinkedHashSet<>();
        TreeSet<String> ts = new TreeSet<>();
        int N = 10;
        ArrayList<Collections> all = new ArrayList<>();
        all.add(null);
        Generator generator = new Generator();
        for (int i = 0; i < N; i++){
            a.add(generator.next());
            l.add(generator.next());
            h.add(generator.next());
            ls.add(generator.next());
            ts.add(generator.next());
        }
        System.out.println(a);
        System.out.println(l);
        System.out.println(h);
        System.out.println(ls);
        System.out.println(ts);
    }
}