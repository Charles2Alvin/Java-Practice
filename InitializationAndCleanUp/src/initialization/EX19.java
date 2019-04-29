package initialization;

enum Coins {
    one, two, three, four, five, six
}

public class EX19 {
    //可变参数列表
    public EX19(String... s) {
        for (String each: s) {
            System.out.print(" "+each);
        }
        System.out.println();
    }

    public void describe(Coins coin) {
        String description;
        switch (coin) {
            case one: description = "It is one.";break;
            case two: description = "It is two.";break;
            case three: description = "It is three.";break;
            case four: description = "It is four.";break;
            case five: description = "It is five.";break;
            case six: description = "It is six.";break;
            default: description = "I don't know...";

        }
        System.out.println(description);
    }
    public static void main(String[] args) {
//        //可以接收一组事物，自动转化成列表
//        EX19 e = new EX19("hi","wow","what");
//        //也可以接收一个String列表
//        EX19 e1 = new EX19(new String[]{"hi","wow","what"});
//        //也可以接收空参数
//        EX19 e2 = new EX19();
        EX20.main("wow","hi", "love", "fantasy");
        System.out.println();
        Coins c = Coins.two;
        EX19 e19 = new EX19();
        e19.describe(c);
        for (Coins coin : Coins.values()) {
            System.out.print(coin+", ");
            e19.describe(coin);
        }


    }
}
