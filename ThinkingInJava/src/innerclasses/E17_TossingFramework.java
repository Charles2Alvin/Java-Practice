package innerclasses;

/****************** Exercise 19 ******************
 * Create a framework using Factory Methods that
 * performs both coin tossing and dice tossing.
 ***********************************************/
interface Tossing { boolean event(); }
interface TossingFactory { Tossing getTossing(); }
class CoinTossing implements Tossing {
    private int events;
    private static final int EVENTS = 2;
    @Override
    public boolean event() {
        System.out.println("Coin tossing event " + events);
        return ++events != EVENTS;
    }
    public static TossingFactory factory = CoinTossing::new;
}

class DiceTossing implements Tossing {
    private int events;
    private static final int EVENTS = 6;
    public boolean event() {
        System.out.println("Dice tossing event " + events);
        return ++events != EVENTS;
    }
    public TossingFactory get(int events) {
        return new TossingFactory() {
            private int num = events;
            public Tossing getTossing() {
                System.out.println(events);
                return new DiceTossing();
            }
        };
    }
    public static TossingFactory factory = DiceTossing::new;
}

public class E17_TossingFramework {
    public static void simulate(TossingFactory fact) {
        Tossing t = fact.getTossing();
        while(t.event())
            ; }
    public static void main(String[] args) {
        simulate(CoinTossing.factory);
        simulate(new DiceTossing().get(155));
    }
}


interface Destination {
    String readLabel();
} ///:~

class Parcel9 {
    // Argument must be final to use inside
    // anonymous inner class:
    public Destination destination(String dest) {
        return new Destination() {
            String what;
            private String label = dest;
            public String readLabel() {
                what = dest;
                //dest = "hi";
                return label;
            }
        };
    }
    public static void main(String[] args) {
        Parcel9 p = new Parcel9();
        Destination d = p.destination("Tasmania");
    }
} ///:~

/* Output:
Coin tossing event 0
Coin tossing event 1
Dice tossing event 0
Dice tossing event 1
Dice tossing event 2
Dice tossing event 3
Dice tossing event 4
Dice tossing event 5
*///:~
