package holding;
/****************** Exercise 3 ******************
 * Modify innerclasses/Sequence.java so you
 * can add any number of elements to it.
 ***********************************************/
//: innerclasses/Sequence.java
// Holds a sequence of Objects.
import java.util.ArrayList;

interface Selector {
    boolean end();
    Object current();
    void next();
}

class Sequence {
    private ArrayList<Object> items = new ArrayList<>();;
    private int next = 0;
    public void add(Object x) {
        items.add(x);
    }
    private class SequenceSelector implements Selector {
        private int i = 0;
        public boolean end() { return i == items.size(); }
        public Object current() { return items.get(i); }
        public void next() { if(i < items.size()) i++; }
    }
    public Selector selector() {
        return new SequenceSelector();
    }
}
public class EX3 {
    public static void main(String[] args) {
        Sequence sequence = new Sequence();
        for(int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));
        Selector selector = sequence.selector();
        while(!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}
/* Output:
0 1 2 3 4 5 6 7 8 9
*///:~
