package yingdg.exercise.se.concurrent.executorframe;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yingdg on 2017/7/27.
 */
public class 阻塞队列存取文件 {
    static long randomTime() {
        return (long) (Math.random() * 1000);
    }

    public static void main(String[] args) {
        // 初始化队列，能容纳100个元素
        final BlockingQueue<File> queue = new LinkedBlockingQueue<>(100);
         /*
        BlockingQueue是阻塞队列。
        该类主要提供了两个方法put()和take()，
        前者将一个对象放到队列中，如果队列已经满了，就等待直到有空闲节点；
        后者从head取一个对象，如果没有对象，就等待直到有可取的对象。
        */

        // 初始化线程池
        ExecutorService exec = Executors.newFixedThreadPool(5);
        // 要扫描文件的根目录
        final File root = new File("E:\\IdeaProjects\\MyGroovyExercise\\src\\main\\java\\yingdg\\exercise");

        // 读文件个数
        final AtomicInteger rc = new AtomicInteger();
        // 写文件个数
        final AtomicInteger wc = new AtomicInteger();
        /*
        AtomicInteger可以在并发情况下达到原子化更新，
        避免使用了synchronized，而且性能非常高。
         */

        // 完成标志
        final File exitFile = new File("");
        /*
        由于阻塞队列的put和take操作会阻塞，为了使线程退出，特在队列中添加了一个“标识”，
        算法中也叫“哨兵”，当发现这个哨兵后，写线程就退出。
         */

        // 一个读线程（多个线程读取文件会产生重复读取）
        Runnable read = new Runnable() {
            @Override
            public void run() {
                scanFile(root);

                // 添加结束标志符
                scanFile(exitFile);
            }

            // 递归算法获取文件
            public void scanFile(File file) {
                // 判断是否为文件夹
                if (file.isDirectory()) {
                    File[] files = file.listFiles(new FileFilter() {
                        @Override
                        public boolean accept(File pathname) {
                            return pathname.isDirectory() || pathname.getPath().endsWith(".java");
                        }
                    });

                    // 如果文件夹下还有文件或文件夹，继续扫描
                    for (File one : files) {
                        scanFile(one);
                    }
                }
                // 获取文件
                else {
                    try {
                        int index = rc.incrementAndGet();
                        // 显示自定义线程名
                        System.out.println("Read0: " + index + " " + file.getPath());
                        // 添加元素到队列中
                        queue.put(file);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        exec.submit(read);

        // 四个写线程
        for (int index = 0; index < 4; index++) {
            // write thread
            final int NO = index;

            Runnable write = new Runnable() {
                // 自定义线程名
                String threadName = "Write" + NO;

                @Override
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(randomTime());
                            int index = wc.incrementAndGet();
                            // 从队列中获取元素
                            File file = (File) queue.take();

                            // 队列已经无对象
                            if (file == exitFile) {
                                System.out.println("读取完毕。"); // 开启的4个读线程都会执行判断
                                // 再次添加"标志"，以便其他线程正常退出
                                queue.put(exitFile);

                                break;
                            }

                            System.out.println(threadName + ": " + index + " " + file.getPath());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            exec.submit(write);
        }

        exec.shutdown();
    }
}
