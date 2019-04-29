package DBApp;

public class VideoGame extends Item {
    private int numOfPlayers;
    public VideoGame(String title, int duration, boolean gotIt, String comment,
                     int numOfTracks, int numOfPlayers) {
        super(title, duration, gotIt, comment, numOfTracks);
        this.numOfPlayers = numOfPlayers;
    }

    @Override
    public void print() {
        System.out.print("Video Game: ");
        super.print();
        System.out.println(numOfPlayers);

    }

}
