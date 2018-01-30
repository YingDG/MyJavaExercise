package yingdg.exercise.se.thread;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by yingdg on 2017/7/21.
 * <p>
 * 使用BlockingQueue
 */
public class 生产者消费者模型3 {
    Executor pool = Executors.newFixedThreadPool(10);

    //仓库
    private BlockingQueue<String> storageQueue = new LinkedBlockingQueue<>(5);

    //仓库容量
    private int MAX_SIZE = 3;

    //仓库为空
    private int ZERO = 0;

    //生产者线程
    private class Producer implements Runnable {

        /*
        生产方法，需同步
         */
        private void produce() {
            try {
                System.out.println(Thread.currentThread().getName() + "进入仓库，准备生产！");

                if (storageQueue.size() == MAX_SIZE) {
                    System.out.println("仓库已满！等待消费者消费");
                    Thread.sleep(1000);
                }
                if (storageQueue.size() <= MAX_SIZE) {
                    String product = "产品" + new Random().nextInt();
                    storageQueue.put(product);
                    System.out.println(Thread.currentThread().getName() + "往仓库中生产了一个产品！");
                    System.out.println("仓库货物数：" + storageQueue.size());
                }

                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                System.out.println("中断异常");
                ie.printStackTrace();
            }
        }

        @Override
        public void run() {
            while (true) {
                produce();
            }
        }
    }

    //消费者线程
    private class Customer implements Runnable {

        /*
        消费方法，需同步
         */
        private void consume() {
            try {
                System.out.println(Thread.currentThread().getName() + "进入仓库，准备消费！");

                if (storageQueue.size() == ZERO) {
                    System.out.println("仓库已空！等待生产者生产");
                    Thread.sleep(1000);
                }
                if (storageQueue.size() != ZERO) {
                    System.out.println(Thread.currentThread().getName() + "从仓库取得产品：" + storageQueue.take());
                    System.out.println("仓库剩余货物数：" + storageQueue.size());
                }

                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                System.out.println("中断异常");
                ie.printStackTrace();
            }
        }

        @Override
        public void run() {
            while (true) {
                consume();
            }
        }

    }

    /*
    /启动生产者和消费者线程
     */
    public void start() {
        for (int i = 1; i < 5; i++) {
            // new Thread(new Producer()).start();
            // new Thread(new Customer()).start();
            pool.execute(new Producer());
            pool.execute(new Customer());
        }

    }

    public static void main(String[] args) {
        new 生产者消费者模型3().start();
    }
}
