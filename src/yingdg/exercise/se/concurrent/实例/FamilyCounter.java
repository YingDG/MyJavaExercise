package yingdg.exercise.se.concurrent.实例;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author zdm
 * created in 2018/10/23 上午10:48
 */
public class FamilyCounter implements Counter {
    private int familyMember;
    private ExecutorService pool;

    public FamilyCounter() {
        this.familyMember = Runtime.getRuntime().availableProcessors();
        this.pool = Executors.newFixedThreadPool(this.familyMember);
    }

    private static class CounterRiceTask implements Callable<Long> {
        private double[] riceArray;
        private int from;
        private int to;

        public CounterRiceTask(double[] riceArray, int from, int to) {
            this.riceArray = riceArray;
            this.from = from;
            this.to = to;
        }

        @Override
        public Long call() throws Exception {
            long total = 0;

            for (int i = from; i <= to; i++) {
                if (riceArray[i] == 1) total += 1;
                if (total >= 0.125e8) break;
            }

            return total;
        }

    }

    /*
    线程池实现
     */
    @Override
    public long count(double[] riceArray) {
        long total = 0;

        List<Future<Long>> results = new ArrayList<>();
        int part = riceArray.length / familyMember;

        for (int i = 0; i < familyMember; i++) {
            results.add(pool.submit(
                    new CounterRiceTask(riceArray, i * part, (i + 1) * part)));
        }

        for (Future<Long> j : results) {
            try {
                total += j.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException ignore) {

            }
        }

        pool.shutdown();
        return total;
    }

}
