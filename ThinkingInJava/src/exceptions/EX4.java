package exceptions;
/****************** Exercise 4 ******************
 * Create your own exception class using the
 * extends keyword. Write a constructor for this
 * class that takes a String argument and stores
 * it inside the object with a String reference.
 * Write a method that prints out the stored
 * String. Create a try-catch clause to exercise
 * your new exception.
 ***********************************************/
public class EX4 {
    public static void main(String[] args) {
        try {
            throw new MyException("Appear!It is my exception!");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }
}
class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}