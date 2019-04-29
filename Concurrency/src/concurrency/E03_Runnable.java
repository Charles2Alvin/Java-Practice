package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class E03_Runnable {
    public static void main(String[] args) {
        //shutdown是异步的方法，用来初始化一系列shutdown步骤
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(new Printer());
        Thread.yield();
        exec.shutdown();
        //**************************************
        exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++)
            exec.execute(new Printer());
        Thread.yield();
        exec.shutdown();
        //**************************************
        exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++)
            exec.execute(new Printer());
        Thread.yield();
        exec.shutdown();
    }
}
