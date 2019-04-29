package huawei;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


public class one {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String str = in.nextLine();
        LinkedList<String> strs = new LinkedList<>();
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < 9*n; i += 9) {
            s.setLength(0);
            for (int j = i; j < i+9; j++) {
                s.append(str.charAt(j));
            }
            strs.add(s.toString());
        }
        for (int i = 0; i < strs.size(); i++) {
            String each = strs.get(i);
            if (each.charAt(0) == '0') {
                String sub = each.substring(1, 9);
                strs.set(i, new StringBuffer(sub).reverse().toString());
            } else {
                strs.set(i, each.substring(1,9));
            }
        }
        Iterator iterator = strs.iterator();
        StringBuffer re = new StringBuffer();
        while (iterator.hasNext()) {
            re.append(iterator.next()+" ");
        }
        re.setLength(re.length()-1);
        System.out.print(re.toString());

    }

}
