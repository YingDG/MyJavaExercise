package yingdg.exercise.se.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yingdg on 2017/7/21.
 * <p>
 * Lock实现的生产者和消费者
 */
public class 生产者消费者模型2 {
    Executor pool = Executors.newFixedThreadPool(10);

    //仓库
    private List<String> storageList = new LinkedList<>();

    //仓库容量
    private int MAX_SIZE = 3;

    //仓库为空
    private int ZERO = 0;

    //获取锁对象
    private Lock lock = new ReentrantLock();

    //仓库满了，绑定生产者线程
    private Condition full = lock.newCondition();

    //仓库为空，绑定消费者线程
    private Condition empty = lock.newCondition();

    //生产者
    private class Producer implements Runnable {

        /*
        生产方法，需同步
         */
        private void produce() {
            if (lock.tryLock()) {
                System.out.println(Thread.currentThread().getName() + "进入仓库，准备生产！");

                try {
                    if (storageList.size() == MAX_SIZE) {
                        System.out.println("仓库已满！等待消费者消费");
                        Thread.sleep(1000);
                        full.await();//生产者线程加入线程等待池
                    }
                    if (storageList.size() < MAX_SIZE) {
                        String name = "产品" + new Random().nextInt();
                        storageList.add(name);
                        System.out.println(Thread.currentThread().getName() + "往仓库中生产了一个产品！");
                        System.out.println("仓库货物数：" + storageList.size());
                    }

                    Thread.sleep(1000);
                    empty.signalAll();//唤醒消费者线程
                } catch (InterruptedException ie) {
                    System.out.println("中断异常");
                    ie.printStackTrace();
                } finally {
                    lock.unlock();
                }

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
            if (lock.tryLock()) {
                System.out.println(Thread.currentThread().getName() + "进入仓库，准备消费！");

                try {
                    if (storageList.size() == ZERO) {
                        System.out.println("仓库已空！等待生产者生产");
                        Thread.sleep(1000);
                        empty.await();//消费者线程加入线程等待池
                    }
                    if (storageList.size() != ZERO) {
                        System.out.println(Thread.currentThread().getName() + "从仓库取得产品：" + storageList.remove(0));
                        System.out.println("仓库剩余货物数：" + storageList.size());
                    }

                    Thread.sleep(1000);
                    full.signalAll();//唤醒生产者线程
                } catch (InterruptedException ie) {
                    System.out.println("中断异常");
                    ie.printStackTrace();
                } finally {
                    lock.unlock();
                }

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
    启动生产者和消费者线程
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
        new 生产者消费者模型2().start();
    }
}
