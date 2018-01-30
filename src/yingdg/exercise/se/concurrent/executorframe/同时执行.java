package yingdg.exercise.se.concurrent.executorframe;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by yingdg on 2017/7/27.
 */
public class 同时执行 {
    /*
    浏览网页时，浏览器了5个线程下载网页中的图片文件，
    由于图片大小、网站访问速度等诸多因素的影响，完成图片下载的时间就会有很大的不同。
    如果先下载完成的图片就会被先显示到界面上，反之，后下载的图片就后显示。

    CompletionService可以满足这种场景要求。
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService exec = Executors.newFixedThreadPool(10);
        CompletionService<String> serv = new ExecutorCompletionService(exec);
        /*
        该接口有两个重要方法：submit()和take()。
        submit用于提交一个runnable或者callable，一般会提交给一个线程池处理；
        而take就是取出已经执行完毕runnable或者callable实例的Future对象，如果没有满足要求的，就等待了。
        CompletionService还有一个对应的方法poll，该方法与take类似，只是不会等待，如果没有满足要求，就返回null对象。
         */

        for (int index = 0; index < 5; index++) {
            final int NO = index;
            Callable<String> downImg = () -> {
                Thread.sleep((long) (Math.random() * 10000));
                return "Downloaded Image " + NO;
            };

            serv.submit(downImg);
            // Future<String> submit = serv.submit(downImg); // 获取当前线程的执行结果，产生强行阻塞效果
            // System.out.println(submit.get());
        }

        // 先展示内容
        Thread.sleep(1000 * 2);
        System.out.println("Show web content");

        // 同时下载图片
        for (int index = 0; index < 5; index++) {
            Future<String> task = serv.take();
            // Future<String> task = serv.poll(); // 无等待，可能返回null
            String img = task.get();
            System.out.println(img);
        }

        System.out.println("End");
        exec.shutdown();
    }
}
