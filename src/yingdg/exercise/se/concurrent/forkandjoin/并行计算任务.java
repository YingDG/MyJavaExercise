package yingdg.exercise.se.concurrent.forkandjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by yingdg on 2017/7/24.
 * <p>
 * Fork&Join框架使用
 */
public class 并行计算任务 extends RecursiveTask<Integer> {
    /*
    RecursiveAction对应没有返回结果的任务，RecursiveTask对应返回结果的任务。
    一般开发ForkJoin程序，主要是实现自定义ForkJoinTask。
     */

    private static final long serialVersionUID = 1224485576707187693L;

    private static final int THRESHOLD = 2; // 阈值
    private int start;
    private int end;

    public 并行计算任务(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        //如果任务足够小就计算任务
        boolean canCompute = (end - start) <= THRESHOLD;

        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            //如果任务大于阀值，就分裂成两个子任务计算
            int middle = (start + end) / 2;

            并行计算任务 leftTask = new 并行计算任务(start, middle);
            并行计算任务 rightTask = new 并行计算任务(middle + 1, end);

            //执行子任务
            leftTask.fork();
            rightTask.fork();
            /*
            fork()
            当ForkJoinTask提交执行任务时，会调用fork()方法。fork会让ForkJoinWorkerThread调用push来异步执行该任务。
             */

            //等待子任务执行完，并得到其结果
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();
            /*
            join()
            join() 方法是阻塞当前进程，等待取得结果.在join的具体实现中，会利用Future的特性查看当前任务的状态来判断返回结果。
             */

            //合并子任务
            sum = leftResult + rightResult;
        }

        return sum;
    }

    public static void main(String[] args) {
        // 初始化任务池
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        // ForkJoinPool forkJoinPool = (ForkJoinPool) Executors.newWorkStealingPool();
        /*
        池中维护着ForkJoinWorkerThread对象数组，
        数组大小由parallelism属性决定，parallelism默认为处理器个数
         */

        //生成一个计算任务，负责计算1+2+3+4
        并行计算任务 task = new 并行计算任务(1, 4);
        //执行一个任务
        Future<Integer> result = forkJoinPool.submit(task);

        try {
            System.out.println(result.get());

            System.out.println(result.isCancelled());
            System.out.println(result.isDone());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        if (task.isCompletedAbnormally()) {
            System.out.println(task.getException());
        }

        forkJoinPool.shutdown();
    }
}
