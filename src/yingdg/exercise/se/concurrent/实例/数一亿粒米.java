package yingdg.exercise.se.concurrent.实例;

/**
 * @author zdm
 * created in 2018/10/23 上午10:27
 */
public class 数一亿粒米 {

    public static void main(String[] args) {
        long length = (long) 1.2e8;
        double[] riceArray = createArray(length);

        Counter counter;
        /*
        单线程
         */
        counter = new FatherCounter(); // 140ms

        /*
        多线程
         */
        counter = new FamilyCounter(); // 67ms

        /*
        工作窃取
         */
        counter = new TogetherCounter(); // 30ms

        long startTime = System.currentTimeMillis();
        long value = counter.count(riceArray);
        long endTime = System.currentTimeMillis();

        System.out.println(value);
        System.out.println("消耗时间(毫秒)：" + (endTime - startTime));
    }

    private static double[] createArray(long length) {
        double[] d2 = new double[(int) length];
        for (int i = 0; i < length; i++) {
            d2[i] = 1;
        }

        return d2;
    }
}
