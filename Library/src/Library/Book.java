package Library;

import java.sql.Timestamp;

public class Book {
    private String title;
    private String author;
    private double price;
    private long bookID;
    private Timestamp borrowTime;
    private String borrower;
    private boolean borrowed;

    public Book() {
    }
}
