package yingdg.exercise.se.concurrent.executorframe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by yingdg on 2017/7/27.
 */
public class 请求个数控制 {
    /*
    Semaphore可以控制某个资源可被同时访问的个数，
    Semaphore维护了当前访问的个数，提供同步机制，控制同时访问的个数。
     */
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();

        // 只能5个线程同时访问
        final Semaphore semp = new Semaphore(200);
        /*
        声明一个只有5个许可的Semaphore，而有20个线程要访问这个资源，
        acquire()获取一个许可，如果没有就等待，而release()释放一个许可。
         */

        // 模拟20个客户端访问
        for (int index = 0; index < 20; index++) {
            final int NO = index;

            Runnable run = () -> {
                try {
                    // 获取许可
                    semp.acquire();
                    System.out.println("Accessing: " + NO);

//                    Thread.sleep(3000);
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 访问完后，释放
                    semp.release();
                }
            };

            exec.execute(run);
        }

        exec.shutdown();
    }
}
