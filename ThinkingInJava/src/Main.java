import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line;
        int oldSum, sum = 0, former = 1, diff = 0;
        line = in.nextLine();
        String[] input = line.split(" ");
        for (int i = 0; i < input.length; i++) {
            int num = Integer.parseInt(input[i]);
            oldSum = sum;
            if (num == 1) sum += 1;
            if (num == 2 && former == 1) sum += 2;
            if (num == 2 && former == 2) sum += diff + 2;
            if (num == 0) break;
            System.out.println(num+" "+sum);
            former = num;
            diff = sum - oldSum;
        }
        System.out.print(sum);
    }
}