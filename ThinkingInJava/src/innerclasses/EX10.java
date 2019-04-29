package innerclasses;

public class EX10 {
    //在方法内部的作用域里，定义内部类并实现接口，并返回这个内部类的引用
    SecondInterface define(boolean need) {
        if (need) {
            class Inner implements SecondInterface {
                @Override
                public void SimpleMethod() {
                    System.out.println("Cool!--from Inner");
                }
            }
            return new Inner();
        }
        return null;
    }
    public static void main(String[] args) {
        EX10 ex10 = new EX10();
        SecondInterface s = ex10.define(true);
        s.SimpleMethod();
    }
}
