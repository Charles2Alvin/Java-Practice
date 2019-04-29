package initialization;

import java.lang.reflect.Array;
import java.util.*;

public class EX13 {
    static String a = "a";
    static String b = "b";
    static {
        b = "b";
        //System.out.println("Static block");
    }
    public EX13() {
        System.out.println("Constructor");
    }
    public static void main(String[] args) {
        //创建两个对象，但是静态代码块只会执行一次
//        for (int i = 0; i < 3; i++) {
//            EX13 e1 = new EX13();
//            System.out.println();
//        }
        //EX13 e1 = new EX13();
        Integer[] d = new Integer[]{
                1,2,3
        };
        Integer[] c = new Integer[1];
        String[] s = {
                "a","b","c"
        };
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
        System.out.println(Arrays.toString(d));
        System.out.println(a);
        System.out.println(b);

    }
}
