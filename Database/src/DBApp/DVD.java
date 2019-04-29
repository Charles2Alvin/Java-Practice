package DBApp;

public class DVD extends Item {
    private String director;

    public DVD(String director,String title, int duration, boolean gotIt,
                                   String comment, int numOfTracks) {
        super(title, duration, gotIt, comment, numOfTracks);
        this.director = director;
    }

    public void print() {
        System.out.print("DVD: ");
        super.print();
        System.out.println(" by "+director);
    }
    public static void main(String[] args) {
        DVD dvd = new DVD("Stan Lee","Iron Man III",
                127,false,"Perfect",997);
        dvd.print();
    }
}
