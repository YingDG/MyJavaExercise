package yingdg.exercise.se.concurrent.executorframe;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by yingdg on 2017/7/27.
 */
public class 定时任务 {
    /*
    许多长时间运行的应用有时候需要定时运行任务完成一些诸如统计、优化等工作。

    比如在电信行业中处理用户话单时，需要每隔1分钟处理话单；
    网站每天凌晨统计用户访问量、用户数；
    大型超时凌晨3点统计当天销售额、以及最热卖的商品；
    每周日进行数据库备份；公司每个月的10号计算工资并进行转帐等，这些都是定时任务。
     */
    public static void main(String[] args) {
        // 初始化定时任务线程池
        final ScheduledExecutorService scheduler =
                Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());

        // 定时任务1
        Runnable runner = () -> {
            System.out.println(new Date() + " 任务1");
        };

        // 定时任务2
        Runnable runner2 = () -> {
            System.out.println("任务2 " + new Date());
        };

        // 1秒钟后运行，并每隔2秒运行一次（永久执行）
        final ScheduledFuture handle =
                scheduler.scheduleAtFixedRate(runner, 1, 2, TimeUnit.SECONDS);

        // 2秒钟后运行，并每次在上次任务运行完后等待5秒后重新运行（永久执行）
        final ScheduledFuture handle2 =
                scheduler.scheduleWithFixedDelay(runner2, 2, 5, TimeUnit.SECONDS);

        // 30秒后结束关闭任务，并且关闭Scheduler
        scheduler.schedule(
                () -> {
                    handle.cancel(true);
                    handle2.cancel(true);
                    scheduler.shutdown();
                },
                30, TimeUnit.SECONDS);
        /*
        为了退出进程，上面的代码中加入了关闭Scheduler的操作。
        而对于24小时运行的应用而言，是没有必要关闭Scheduler的。
         */
    }
}
