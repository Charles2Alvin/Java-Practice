public class Main {

    public static void main(String[] args) {

        java.util.Scanner in = new java.util.Scanner(System.in);

        Clock clock = new Clock(in.nextInt(), in.nextInt(), in.nextInt());

        clock.tick();
        System.out.println(clock);

        in.close();
    }
}

class Display {
    int value;
    int limit;
    Display(int limit) {
        this.limit = limit;
    }
    public void increase() {
        value ++;
        if (value == limit) {
            value = 0;
        }
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
}

class Clock {
    private Display hour;
    private Display minute;
    private Display second;

    public Clock(int hour, int minute, int second) {
        this.hour = new Display(24);
        this.minute = new Display(60);
        this.second = new Display(60);

        this.hour.setValue(hour);
        this.minute.setValue(minute);
        this.second.setValue(second);
    }
    public void tick() {
        second.increase();
        if (second.getValue() == 0) {
            minute.increase();
            if (minute.getValue() == 0) {
                hour.increase();
            }
        }
    }
    public String toString() {
        String form = String.format("%02d:%02d:%02d",hour.getValue(),minute.getValue(),second.getValue());
        return form;
    }

    public void start() {
        int i = 0;
        while (i < 1000) {
            second.increase();
            if (second.getValue() == 0) {
                minute.increase();
                if (minute.getValue() == 0) {
                    hour.increase();
                }
            }
            i ++;
            System.out.println(toString());
        }

    }
}