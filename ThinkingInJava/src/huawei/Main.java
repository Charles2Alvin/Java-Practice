package huawei;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(" ");
        int z = 0;
        LinkedList<Point> lst = new LinkedList<>();
        while (z < 10) {
            int x = Integer.parseInt(input[z]);
            int y = Integer.parseInt(input[z+1]);
            lst.add(new Point(x, y));
            z += 2;
        }
        Iterator iterator = lst.iterator();
        while (iterator.hasNext()) {
            Point p = (Point) iterator.next();
        }
        double de = 10000000;
        for(int i: Arrays.asList(0, 1, 2, 3, 4)) {
            for(int j: Arrays.asList(0, 1, 2, 3, 4)) {
                if (Arrays.asList(i).contains(j)) continue;
                for(int k: Arrays.asList(0, 1, 2, 3, 4)) {
                    if (Arrays.asList(i, j).contains(k)) continue;
                    for(int m: Arrays.asList(0, 1, 2, 3, 4)) {
                        if (Arrays.asList(i,j,k).contains(m)) continue;
                        for(int n: Arrays.asList(0, 1, 2, 3, 4)) {
                            if (Arrays.asList(i, j, k, m).contains(n)) continue;
                            double length = 0;
                            length += lst.get(i).distance(lst.get(j).x, lst.get(j).y);
                            length += lst.get(j).distance(lst.get(k).x, lst.get(k).y);
                            length += lst.get(k).distance(lst.get(m).x, lst.get(m).y);
                            length += lst.get(m).distance(lst.get(n).x, lst.get(n).y);
                            if (length < de) {
                                de = length;
                            }
                        }
                    }
                }
            }
        }
        //System.out.println("sasas");
        //System.out.println(lst.get(0).x+" "+lst.get(0).y);
        System.out.println((int)de);
    }
}
