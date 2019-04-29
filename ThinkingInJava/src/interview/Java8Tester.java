package interview;

import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
public class Java8Tester {
    public static  void transfer() {
        /**
         * 列表转数组
         */
        List<String> list = Arrays.asList("2","3","1");
        String[] nums = list.toArray(new String[0]);

        List<Integer> listNum = Arrays.asList(1,2,3);
        Integer[] intNums = listNum.toArray(new Integer[0]);

        /**
         * 数组转换成列表
         */
        //方法一：使用列表构造器，用asList方法将数组转换为列表，作为构造器参数
        Integer[] integers = {6,6,6,6,6,6,6,6};
        List<Integer> integerList = new ArrayList<>(Arrays.asList(integers));
        integerList.add(1);


        //方法二：java8新特性stream
        int[] ints = {7,7,7};
        List<Integer> integerList1 = Arrays.stream(ints).boxed().collect(Collectors.toList());
        //如果需要ArrayList
        ArrayList<Integer> integerList2 = Arrays.stream(ints).boxed().collect(
                Collectors.toCollection(ArrayList::new));

        //方法三：先创建列表，再用addAll方法添加
        LinkedList list1 = new LinkedList();
        //noinspection unchecked
        Collections.addAll(list1,ints);
        list1.add(888);
    }

    private static void compareToInnerClass() {
        Cal num = new Cal() {
            @Override
            public void calculate() {
                System.out.println("Using anonymous class!");
            }
        };
        Cal num1 = ()-> System.out.println("Using lambda expression!");
        num1.calculate();
        num.calculate();
        //int sum = list.stream().map(x -> x*x).reduce((x,y) -> x + y).get();
        //System.out.println(sum);
        //int size = list.size();



    }
    public static void main(String args[]){
        Java8Tester tester = new Java8Tester();

        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> a * b;

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        //返回两倍
        MathOperation doubleNum = (int x, int power) -> 2 * x + power;



        System.out.println("10 + 5 = " + tester.operate(addition));
        System.out.println("10 - 5 = " + tester.operate(subtraction));
        System.out.println("10 x 5 = " + tester.operate(multiplication));
        System.out.println("10 / 5 = " + tester.operate(division));
        System.out.println("10 * 2 = " + tester.operate(doubleNum));

        // 不用括号
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        // 用括号
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");
        compareToInnerClass();
        System.out.println("ha??");
    }
    @FunctionalInterface
    interface Cal {
         void calculate();
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(MathOperation mathOperation){
        return mathOperation.operation(10, 5);
    }
}