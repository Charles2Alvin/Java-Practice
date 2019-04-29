package holding;

import java.util.Iterator;
import java.util.NoSuchElementException;

class Sequence2 {
    private Object[] items;
    private int next = 0;

    public Sequence2(int size) {
        items = new Object[size];
    }
    public void add(Object x) {
        if (next < items.length)
            items[next++] = x;
    }
    private class SequenceSelector implements Iterator{
        private int i = 0;
        @Override
        public boolean hasNext() {
            return i < items.length;
        }
        @Override
        public Object next() {
            if (hasNext()) return items[i++];
            throw new NoSuchElementException();
        }
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    public Iterator iterator() {
        return new SequenceSelector();
    }
}
public class EX9 {
    public static void main(String[] args) {
        Sequence2 sequence = new Sequence2(10);
        for (int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));
        Iterator<Sequence2> iterator = sequence.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}