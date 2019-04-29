package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
    public static void main(String[] args) {
        //由中介对象executor执行任务
        //单个的Executor创建和管理系统中的所有任务
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i=0; i < 3; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
        System.out.println("Waiting for Liftoff");
    }
}
