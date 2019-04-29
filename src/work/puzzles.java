package work;

public class puzzles{
    public int count = 0;
    public static void main(String[] args){
        puzzles p = new puzzles();
        p.guess(3);
    }


    public static void guess(int n){
        for (int k=0; k<n; k++){
            //this.count++;
            System.out.print(k);
            System.out.print(n);
            System.out.println();
            n--;
            guess(n);
        }

    }
}