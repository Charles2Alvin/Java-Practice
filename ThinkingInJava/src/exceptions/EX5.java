package exceptions;

public class EX5 {
    public static void main(String[] args) {
        int[] nums = new int[5];
        int index = 10;
        while (true) {
            try {
                nums[index] = 1;
            }catch (Exception e) {
                index--;
                System.out.println("error, index = " + index);
            }
        }
    }
}
