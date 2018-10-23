package yingdg.exercise.se.concurrent.实例;

/**
 * @author zdm
 * created in 2018/10/23 上午10:30
 */
public class FatherCounter implements Counter {

    /*
    单核单线程实现
     */
    @Override
    public long count(double[] riceArray) {
        long total = 0;

        for (double i : riceArray) {
            if (i == 1) total += 1;
            if (total >= 1e8) break;
        }

        return total;
    }

}
