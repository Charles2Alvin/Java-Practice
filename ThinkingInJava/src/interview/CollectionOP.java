package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CollectionOP {
    ArrayList<Integer> list1 = new ArrayList<>(
            Arrays.asList(1,2,3,4,5,6)), list2 = new ArrayList<>(
            Arrays.asList(4,5,6,7,8,9));
    public void test() {
        /**
         * 两个集合求并集，addAll方法，会有重复元素
         */
        list1.addAll(list2);
        traverse();
        /**
         * 差集运算
         */
        list1.removeAll(list2);
        traverse();

        list1.addAll(Arrays.asList(4,5,6));
        /**
         * 保留两个集合的交集
         */
        list1.retainAll(list2);
        traverse();

        list1.addAll(Arrays.asList(1,2,3));
        /**
         * 求无重复的并集：先去掉交集，再作合并
         */
        list1.removeAll(list2);
        list1.addAll(list2);
        traverse();
    }
    public static void main(String[] args) {
        CollectionOP op = new CollectionOP();
        op.test();
    }
    public void traverse() {
        Iterator<Integer> iterator = list1.iterator();
        while (iterator.hasNext())
            System.out.print(iterator.next()+" ");
        System.out.println();
    }
}
