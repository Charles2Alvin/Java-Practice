package exceptions;
/****************** Exercise 3 ******************
 * Write code to generate and catch an
 * ArrayIndexOutOfBoundsException.
 ***********************************************/
public class EX3 {
    public static void main(String[] args) {
        int[] a = new int[5];
        try {
            a[5] = 5;
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
