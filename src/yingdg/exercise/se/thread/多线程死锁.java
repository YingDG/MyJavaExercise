package yingdg.exercise.se.thread;

/**
 * Created by yingdg on 2017/7/20.
 */
public class 多线程死锁 {
    private final Object o1 = new Object();
    private final Object o2 = new Object();

    public void method1() {
        synchronized (o1) {
            System.out.println(Thread.currentThread().getName() + " is going");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (o2) {
                System.out.println("o1 -> o2");
            }
        }
    }

    public void method2() {
        synchronized (o2) {
            System.out.println(Thread.currentThread().getName() + " is going");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (o1) {
                System.out.println("o2 -> o1");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("线程死锁");

        多线程死锁 lock = new 多线程死锁();
        new Thread(lock::method1, "A").start();
        new Thread(() -> lock.method2(), "B").start();
    }
}
