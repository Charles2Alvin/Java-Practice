package initialization;

public class EX10 {
    private int i = 3;
    void cleanUp() {
        i = 0;
    }
    @Override
    protected void finalize() {
        if (i != 0) {
            System.out.println("forget clean-up");
        }
    }
    public static void main(String[] args) {
        int N = 1;
        for (int i = 0; i < N; i++) {
            EX10 ex10 = new EX10();
//            ex10.cleanUp();
//            ex10.finalize();
            //ex10.cleanUp();
        }
        System.gc();
    }
}
