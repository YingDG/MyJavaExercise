package yingdg.exercise.se.concurrent.executorframe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yingdg on 2017/7/27.
 */
public class 线程池示例 {
    public static void main(String[] args) {
        // 初始化线程池，根据CPU内核数决定线程数
        final ExecutorService exec = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        /*
        Executors的静态函数生成一个固定的线程池，线程池的线程是不会释放的。
        这就会产生性能问题，当全部使用完毕后，所有的线程会继续留在池中，相应的内存和线程切换都会增加。
        如果要避免这个问题，就必须直接使用ThreadPoolExecutor()来构造
         */

        // 执行50次操作
        for (int i = 0; i < 50; i++) {
            Runnable runner = () -> {
                System.out.println("使用的线程：" + Thread.currentThread().getName());

                long time = (long) (Math.random() * 1000);
                System.out.println("Sleeping " + time + "ms");

                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };

            exec.submit(runner);
            // Future<?> future = exec.submit(runner); // callable返回结果
        }

        // 关闭线程池
        // System.out.println(exec.isShutdown());
        exec.shutdown();
        /*
        线程池必须使用shutdown来显式关闭，否则主线程就无法退出。
        shutdown也不会阻塞主线程。
         */
    }
}
