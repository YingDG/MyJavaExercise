package yingdg.exercise.se.concurrent.实例;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author zdm
 * created in 2018/10/23 上午11:08
 */
public class TogetherCounter implements Counter {
    private int familyMember;
    private ForkJoinPool pool;
    // 阀值
    private static final int THRESHOLD = 8000; // 本例6000-8000为宜

    public TogetherCounter() {
        this.familyMember = Runtime.getRuntime().availableProcessors();
        this.pool = new ForkJoinPool(this.familyMember);
    }

    private static class CounterRiceTask extends RecursiveTask<Long> {
        private double[] riceArray;
        private int from;
        private int to;

        public CounterRiceTask(double[] riceArray, int from, int to) {
            this.riceArray = riceArray;
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            long total = 0;

            /*
            将一个大型任务分割成小任务，并以先进后出的规则（LIFO）来执行.
            任务需要按照一定的顺序来执行时，ForkJoin将发挥其能力
             */
            if (to - from <= THRESHOLD) {
                for (int i = from; i < to; i++) {
                    if (riceArray[1] == 1) total += 1;
                }

                return total;
            } else {
                int mid = (from + to) / 2;

                CounterRiceTask left = new CounterRiceTask(riceArray, from, mid);
                left.fork();

                CounterRiceTask right = new CounterRiceTask(riceArray, mid + 1, to);
                right.fork();

                return left.join() + right.join();
            }
        }
    }

    @Override
    public long count(double[] riceArray) {
        return pool.invoke(new CounterRiceTask(riceArray, 0, riceArray.length - 1));
    }

}
