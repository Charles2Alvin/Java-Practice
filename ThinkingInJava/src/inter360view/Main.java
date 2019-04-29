package inter360view;

import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int n = Integer.parseInt(s);
        for (int i = 0; i < n; i++) {
            String[] input = in.nextLine().split(" ");
            int p1 = Integer.parseInt(input[0]);
            int p2 = Integer.parseInt(input[1]);
            int p3 = Integer.parseInt(input[2]);
            int p4 = Integer.parseInt(input[3]);
            //处理p4
            int pairs = p4;

            //处理p2
            if (p2 % 2 == 0 && p2 != 0) {
                pairs += p2/2;
                p2 = 0;
            }
            else {
                pairs += (p2 - 1)/2;
                p2 = 1;
            }

            //处理p1和p3
            if (p2 == 0) {
                if (p1 < p3) {
                    pairs += p1;
                }
                else {
                    pairs += p3;
                    p1 -= p3;
                    pairs += (p1 - p1 % 4)/4;

                }

                System.out.println(pairs);
            } else {
                int res1 = pairs, res2 = pairs;
                //先补充二人队
                res1++;
                p1 -=2;
                res1 += Math.min(p1, p3);
                //先补充三人队
                if (p3 == 0) {
                    if (p1 >= 2) {
                        res2++;
                    }
                }else {
                    if (p1 > p3) {
                        res2 += p3;
                        p1 -= p3;
                        if (p1 >= 2)
                            res2++;
                    } else {
                        res2 += p1;
                    }
                }
                System.out.println(Math.max(res1, res2));
                ReentrantLock lock = new ReentrantLock();
            }

        }
    }
}
