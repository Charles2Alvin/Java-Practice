package innerclasses;

/****************** Exercise 16 ******************
 * Use anonymous inner classes to modify the
 * solution to Exercise 18 from the Interfaces chapter.
 ***********************************************/
/****************** Exercise 18 ******************
 * Create a Cycle interface, with implementations
 * Unicycle, Bicycle, and Tricycle. Create factories
 * for each type of Cycle, and code that uses
 * these factories.
 ***********************************************/
interface Cycle {
    int wheels();
}
interface CycleFactory {
    Cycle getCycle();
}
class Unicycle implements Cycle {
    public int wheels() {
        return 1;
    }
//    public static CycleFactory factory = new CycleFactory() {
//        @Override
//        public Cycle getCycle() {
//            return new Unicycle();
//        }
//    };
//    public static CycleFactory factory = () -> new Unicycle();
    public static CycleFactory factory = Unicycle::new;
}

class Bicycle implements Cycle {
    int wheels;
    static int numOfWheel;
    public int wheels() {
        return 2;
    }
    public static CycleFactory factory = Bicycle::new;
    class inner {
        Bicycle g() {
            return Bicycle.this;
        }
    }
    static class sinner {
        //wheels = 0;
        {numOfWheel = 1;}
        Bicycle f() {
            //wheels();
            //return Bicycle.this;
            return null;
        }
    }
}

class Tricycle implements Cycle {
    public int wheels() {
        return 3;
    }
    public static CycleFactory factory = new CycleFactory() {
        @Override
        public Cycle getCycle() {
            return new Tricycle();
        }
    };
}

public class E16_CycleFactories
{
    public static void ride(CycleFactory fact) {
        Cycle c = fact.getCycle();
        System.out.println("Num. of wheels: " + c.wheels());
    }



    public static void main(String[] args) {
        ride(Unicycle.factory);
        ride(Bicycle.factory);
        ride(Tricycle.factory);
    }
} /* Output:
         Num. of wheels: 1
         Num. of wheels: 2
         Num. of wheels: 3

         *///:~

//class innerU implements Cycle,CycleFactory{
//    @Override
//    public int wheels() {
//        return 0;
//    }
//
//    @Override
//    public Cycle getCycle() {
//        return null;
//    }
//}