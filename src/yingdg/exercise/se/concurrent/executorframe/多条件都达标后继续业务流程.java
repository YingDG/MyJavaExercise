package yingdg.exercise.se.concurrent.executorframe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yingdg on 2017/7/27.
 */
public class 多条件都达标后继续业务流程 {
    /*
    在一些应用场合中，需要等待某个条件达到要求后才能做后面的事情；
    同时当线程都完成后也会触发事件，以便进行后面的操作。
     */
    public static void main(String[] args) throws InterruptedException {
        // 开始的倒数锁
        final CountDownLatch begin = new CountDownLatch(1);
        // 结束的倒数锁
        final CountDownLatch end = new CountDownLatch(10);
        /*
        CountDownLatch是一个倒数计数的锁，
        当倒数到0时触发事件，也就是开锁，后续操作就可以开始。

        CountDownLatch最重要的方法是countDown()和await()，
        前者主要是倒数一次，后者是等待倒数到0，如果没有到达0，就只有阻塞等待了。

        一个CountDouwnLatch实例是不能重复使用的，锁一经被打开就不能再关闭使用了，
        如果想重复使用，考虑使用CyclicBarrier，即有多次await操作。
         */

        /*
        赛跑模型
         */
        // 十名选手
        ExecutorService exec = Executors.newFixedThreadPool(10);

        // 开始赛跑
        for (int index = 0; index < 10; index++) {
            final int NO = index + 1;

            Runnable run = () -> {
                try {
                    begin.await(); // 所有线程等待主线程信号

                    Thread.sleep((long) (Math.random() * 10000));
                    System.out.println("No." + NO + " arrived");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    end.countDown();
                }
            };

            exec.submit(run);
        }

        // begin计数归零后，开始
        System.out.println("Game Start");
        begin.countDown();

        // end计数归零后，结束
        end.await();
        System.out.println("Game Over");

        exec.shutdown();
    }
}
