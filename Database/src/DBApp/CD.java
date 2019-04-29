package DBApp;

public class CD extends Item {
    private String artist;

    public CD(String artist, String title, int duration,
              boolean gotIt, String comment,int numOfTracks) {

        super(title,duration,gotIt,comment,numOfTracks);
        this.artist = artist;
    }

    public void print() {
        System.out.print("CD: ");
        super.print();
        System.out.println(" by "+artist);
    }
    public static void main (String[] args){
        CD cd = new CD("Taylor","Last Christmas",
                999,false,"Awesome",999);
        cd.print();
    }
}
