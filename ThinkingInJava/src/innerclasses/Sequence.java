package innerclasses;

interface Selector {
    boolean end();
    Object current();
    void next();
}

public class Sequence {
    private Object[] items;
    private int next = 0;
    public Sequence(int size) {
        items = new Object[size];
    }
    public void add(Object x) {
        items[next++] = x;
    }
    private class SequenceSelector implements Selector {
        private int i = 0;
        public Sequence getOuter() {
            return Sequence.this;
        }
        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length) {
                i++;
            }
        }
    }//end private class
    public Selector selector() {
        return new SequenceSelector();
    }
    public static void main(String[] args) {

    }
}