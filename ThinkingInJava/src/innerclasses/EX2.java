package innerclasses;

public class EX2 {
    private String name;

    public EX2(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "EX2{" +
                "name='" + name + '\'' +
                '}';
    }
    public static void main(String[] args) {
        //迭代器模式，创建一个序列对象用于存放，一个选择器对象用来操作
        int size = 5;
        Sequence sequence = new Sequence(5);
        sequence.add(new EX2("I"));
        sequence.add(new EX2("am"));
        sequence.add(new EX2("trying"));
        sequence.add(new EX2("hard"));
        sequence.add(new EX2("yeah"));
        //用序列的getter接口来创建对象
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.println(selector.current().toString() + " ");
            selector.next();
        }
    }
}