package yingdg.exercise.se.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yingdg on 2018/3/3.
 */
public class 线程间通讯 {
    /*
    volatile, synchronized关键字配合
     */
    private volatile List<Integer> values = new ArrayList<>();
    private volatile boolean canGet = false;
    private Object lock = new Object();

    public void put() {
        synchronized (lock) {
            for (int i = 1; i < 11; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + ":" + i);
                values.add(i);

                if (values.size() == 5) {
                    System.out.println("开始取值");
                    canGet = true;
                    lock.notify(); // 不放锁，直到执行完毕
                }
            }
        }
    }

    public void get() {
        synchronized (lock) {
//            while (true) {
            try {
                lock.wait(); // 必须先执行wait，再执行notify
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("values:");
            if (canGet) {
                System.out.println(Thread.currentThread().getName() + ":" + values);
//                    break;
            }
//            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        线程间通讯 t = new 线程间通讯();

        new Thread(() -> t.get(), "B").start();
        Thread.sleep(1000);
        new Thread(t::put, "A").start();
    }
}
