package concurrency;

public class LiftOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;
    public LiftOff() {System.out.println("New task "+id);}
    public LiftOff(int countDown) {
        this.countDown = countDown;
        System.out.println("New task "+id);
    }
    public String status() {
        return "#" + id + "(" +
                (countDown > 0 ? countDown : "Liftoff!") +"), ";
    }
    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());
            Thread.yield();
        }
        System.out.println("\nTask "+id+" terminated");
    }
}
class MainThread {
    public static void main(String[] args) {
        LiftOff launch = new LiftOff();
        launch.run();
    }
}