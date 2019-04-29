package DBApp;

import java.util.ArrayList;

public class Database {
    private ArrayList<Item> listItem = new ArrayList<Item>();
    public void add(Item item) {
        listItem.add(item);
    }
    public void list() {
        for (Item item : listItem) {
            item.print();
        }
    }
    public static void main(String[] args) {
        Database db = new Database();
        Item item = new Item("Last Christmas", 999, false,
                "Awesome", 999);
        DVD dvd = new DVD("Stan Lee","Iron Man III",
                127,false,"Perfect",997);
        //dvd = (DVD) item;
        item = dvd;
        db.add(new CD("Last Christmas", "Taylor Swift",
                999, false,
                "Awesome", 999));
        db.add(new DVD("Stan Lee","Iron Man III",
                127,false,"Perfect",997));
        db.list();
        System.out.println("..");
    }
}
