package yingdg.exercise.se.concurrent.executorframe;

import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by yingdg on 2017/7/27.
 */
public class 主次任务并行 {
    /*
    有时候在实际应用中，某些操作很耗时，但又不是不可或缺的步骤。
    比如用网页浏览器浏览新闻时，最重要的是要显示文字内容，至于与新闻相匹配的图片就没有那么重要的，
    所以此时首先保证文字信息先显示，而图片信息会后显示，但又不能不显示，
    由于下载图片是一个耗时的操作，所以必须一开始就得下载。
    Future类就可以满足这个要求。

    下面的Demo简单的说明了Future的使用方法：
    一个非常耗时的操作必须一开始启动，但又不能一直等待；
    其他重要的事情又必须做，等完成后，就可以做不重要的事情。
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService exec = null;
        try {
            exec = Executors.newSingleThreadExecutor();
            //                Executors.newFixedThreadPool(5);

            Callable<String> call = () -> {
//                Thread.sleep(1000 * 5);
                TimeUnit.SECONDS.sleep(5L);
                return "Other less important but longtime things.";
            };

            // 首先开始的事情
            System.out.println("Other less important things which is first");
            Future<String> task = exec.submit(call); // 开始不重要但开始必须执行的事情
            /*
            Future的重要方法包括get()和cancel()，get()获取数据对象，如果数据没有加载，就会阻塞直到取到数据，
            而 cancel()是取消数据加载。
            另外一个get(timeout)操作，表示如果在timeout时间内没有取到就失败抛出异常，而不再阻塞。
            */

            // 重要的事情
//            Thread.sleep(1000 * 3);
            TimeUnit.SECONDS.sleep(3L);
            System.out.println("\nLet's do important things.");

            while (!task.isDone()) {
                TimeUnit.SECONDS.sleep(1L);
                System.out.println("undone");
            }

            // 其他不重要的事情
            System.out.println(task.get(3, TimeUnit.SECONDS));
            String obj = task.get(); // 阻塞等待返回结果
            System.out.println(obj);
        } finally {
//            if (Objects.nonNull(exec)) exec.shutdown();
            Optional.ofNullable(exec).ifPresent(ExecutorService::shutdown);
        }
    }
}
