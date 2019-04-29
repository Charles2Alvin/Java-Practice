package DBApp;

public class Item extends Object{
    private String title;
    private int duration;
    private boolean gotIt;
    private String comment;
    private int numOfTracks;

    public Item(String title, int duration, boolean gotIt,
                String comment, int numOfTracks) {
        this.title = title;
        this.duration = duration;
        this.gotIt = gotIt;
        this.comment = comment;
        this.numOfTracks = numOfTracks;
    }

    public void print() {
        System.out.print(title);
    }
}
