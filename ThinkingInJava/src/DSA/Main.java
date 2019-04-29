package DSA;
import java.io.*;
import java.util.*;
public class Main {
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T,n;
        String[] line1 = in.nextLine().split(" ");
        T = Integer.parseInt(line1[0]);
        n = Integer.parseInt(line1[1]);
        LinkedList<LinkedList<String>> input = new LinkedList<LinkedList<String>>();
        //Store the result;
        int[] re = new int[T];
        int count= 0;
        for (int i = 0; i < T*n; i+= n) {
            //read the i-th code
            input = new LinkedList<LinkedList<String>>();
            for (int j = 0; j < n; j++) {
                input.add(new LinkedList<String>());
            }
            for (int j = 0; j < n; j++) {
                String line = in.nextLine();
                String[] strs = line.split(" ");
                //System.out.println(line+" "+i+" "+j);
                for (String str : strs)
                    input.get(j).add(str);
            }
            //the above handles reading
            boolean flag = true;
            for (int p = 0; p < n && flag; p++) {
                int length = input.get(p).size();
                //handles the p-th line for process p per code
                for (int q = 0; q < length; q++){
                    //the q-th instruction of the line
                    String instruction = input.get(p).get(q);
                    String action = instruction.substring(0,1);
                    int pNum = Integer.parseInt(instruction.substring(1));

                    HashSet set = new HashSet();
                    int lenPNum = input.get(pNum).size();
                    for (int t = 0; t < lenPNum; t++) {
                        set.add(input.get(pNum).get(t));
                    }
                    //Collections.addAll(set, input.get(pNum));
                    StringBuffer s = new StringBuffer();
                    String ask = "S" + p;
                    if (action.equals("S")) ask = "R"+p;
                    if (!set.contains(ask)) {

                        System.out.println(111+" "+instruction+" "+ask);
                        //System.out.println(set);
                        re[count] = 1;
                        flag = false;
                        break;
                    } else {
                        int index = input.get(pNum).indexOf(ask);
                        set = new HashSet();
                        for (int w = 0; w < index; w++){
                            set.add(input.get(pNum).get(w));
                        }
                        String contrast = action + p;
                        //System.out.println(contrast);
                        if (set.contains(contrast)) {

                            System.out.println(222);

                            re[count] = 1;
                            flag = false;
                            break;
                        } else {

                            System.out.println(333);
                            input.get(p).set(q, "Q7");
                            input.get(pNum).set(index, "Q7");
                        }
                    }


                    //System.out.println(instruction+" "+ask);
                }


            }
            boolean flg = true;
            for (int e = 0; e < n && flg; e++) {
                int newlen = input.get(e).size();
                for (int d =0; d < newlen && flg; d++) {
                    if (!input.get(e).get(d).equals("Q7")) {
                        flg = false;
                        break;
                    }
                }
            }
            if(flg == true)
                re[count] = 0;
            else re[count] = 1;
            count++;

        }
        for (int i = 0; i < T; i++) {
            System.out.println(re[i]);
        }


    }
}