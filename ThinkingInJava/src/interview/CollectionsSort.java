package interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * TODO Collections * @author
 * @date 2017 11 20 * @version 1.8
 */
public class CollectionsSort {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(-1);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(-5);
        arrayList.add(7);
        arrayList.add(4);
        arrayList.add(-9);
        arrayList.add(-7);
        arrayList.add(4);
        arrayList.add(-9);
        arrayList.add(-7);
        System.out.println(" :"); System.out.println(arrayList);
        Collections.reverse(arrayList);
        System.out.println("Collections.reverse(arrayList):");
        System.out.println(arrayList);
        Collections.sort(arrayList);
        System.out.println("Collections.sort(arrayList):");
        System.out.println(arrayList);
        Collections.shuffle(arrayList);
        System.out.println("Collections.shuffle(arrayList):");
        System.out.println(arrayList);
        Collections.sort(arrayList, Comparator.reverseOrder());
        System.out.println("          ");
        System.out.println(arrayList);
    }
}

