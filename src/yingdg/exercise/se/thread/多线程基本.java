package yingdg.exercise.se.thread;

/**
 * Created by yingdg on 2017/7/20.
 */
public class 多线程基本 implements Runnable {
    private int i = 1000;

    // run方法中的执行都是异步的
    @Override
    public void run() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName());
            System.out.println("线程的变量：" + i--);
        }
    }

    public static void main(String[] args) {
        多线程基本 多线程 = new 多线程基本();

        // 创建1000个线程进行异步操作
        for (int i = 0; i < 1000; i++) {
            Thread t = new Thread(多线程);

            // 前200个线程设置为低优先级
            if (i < 200) {
                t.setPriority(Thread.MIN_PRIORITY);
            }

            t.start();
        }
    }
}
