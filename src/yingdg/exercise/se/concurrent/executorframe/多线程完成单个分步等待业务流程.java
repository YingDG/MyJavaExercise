package yingdg.exercise.se.concurrent.executorframe;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yingdg on 2017/7/27.
 */
class 旅程 implements Runnable {
    private int[] times;
    private CyclicBarrier barrier;
    private String tourName;

    public 旅程(CyclicBarrier barrier, String tourName, int[] times) {
        this.times = times;
        this.barrier = barrier;
        this.tourName = tourName;
    }

    private String now() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(new Date()) + ": ";
    }

    @Override
    public void run() {
        // 本身是全流程，执行到某一阶段后等待其他线程也执行到这一阶段
        try {
            Thread.sleep(times[0] * 1000);
            System.out.println(now() + tourName + " Reached Shenzhen");
            barrier.await(); // 每个线程都执行这一步才继续

            Thread.sleep(times[1] * 1000);
            System.out.println(now() + tourName + " Reached Guangzhou");
            barrier.await();

            Thread.sleep(times[2] * 1000);
            System.out.println(now() + tourName + " Reached Shaoguan");
            barrier.await();

            Thread.sleep(times[3] * 1000);
            System.out.println(now() + tourName + " Reached Changsha");
            barrier.await();

            Thread.sleep(times[4] * 1000);
            System.out.println(now() + tourName + " Reached Wuhan");
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

public class 多线程完成单个分步等待业务流程 {
    /*
    在实际应用中，有时候需要多个线程同时工作以完成同一件事情，
    而且在完成过程中，往往会等待其他线程都完成某一阶段后再执行，等所有线程都到达某一个阶段后再统一执行。

    比如有几个旅行团需要途经深圳、广州、韶关、长沙最后到达武汉。
    旅行团中有自驾游的，有徒步的，有乘坐旅游大巴的；
    这些旅行团同时出发，并且每到一个目的地，都要等待其他旅行团到达此地后再同时出发，直到都到达终点站武汉。
    这时候CyclicBarrier就可以派上用场。
     */
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(3);

        // 徒步需要的时间: Shenzhen, Guangzhou, Shaoguan, Changsha, Wuhan
        int[] timeWalk = {5, 8, 15, 15, 10};
        // 自驾游
        int[] timeSelf = {1, 3, 4, 4, 5};
        // 旅游大巴
        int[] timeBus = {2, 4, 6, 6, 7};

        // 三个旅行团
        final CyclicBarrier barrier = new CyclicBarrier(3); // 可以有多次await操作
        /*
        CyclicBarrier最重要的属性就是参与者个数，另外最主要方法是await()。
        当所有线程都调用了await()后，就表示这些线程都可以继续执行，否则就会等待。
         */

        // 使用同一个CyclicBarrier
        exec.submit(new 旅程(barrier, "WalkTour", timeWalk));
        exec.submit(new 旅程(barrier, "SelfTour", timeSelf));
        exec.submit(new 旅程(barrier, "BusTour", timeBus));

        exec.shutdown();
    }
}
