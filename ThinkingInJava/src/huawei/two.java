package huawei;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public double distance(int p, int q) {
        return Math.sqrt(Math.pow(x - p, 2) + Math.pow(y - q, 2));
    }
}

public class two {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(" ");
        int i = 0;
        LinkedList<Point> lst = new LinkedList<>();
        while (i < 10) {
            int x = Integer.parseInt(input[i]);
            int y = Integer.parseInt(input[i+1]);
            lst.add(new Point(x, y));
            i += 2;
        }
        Iterator iterator = lst.iterator();
        while (iterator.hasNext()) {
            Point p = (Point) iterator.next();
            //System.out.println(p.x+" "+p.y);
        }
        double length = 0;
        Point cur = new Point(0, 0);
        while (!lst.isEmpty()) {
            double distance = lst.get(0).distance(cur.x, cur.y);
            int index = 0;
            for (i = 0; i < lst.size(); i++) {
                double curDistance = lst.get(i).distance(cur.x, cur.y);
                if (curDistance < distance) {
                    distance = curDistance;
                    index = i;
                }
            }
            cur = lst.get(index);
            lst.remove(index);
            length += distance;
        }
        length += cur.distance(0, 0);
        System.out.println((int)length);
    }
}
