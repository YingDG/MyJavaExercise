package yingdg.exercise.se.common;

/**
 * @author zdm
 * created in 2018/6/5 下午2:48
 */
public class NumberTest {
    public static void main(String[] args) {
        int size = Byte.SIZE;
        System.out.println(size);

        int bytes = Byte.BYTES;
        System.out.println(bytes);

        int sum = Integer.sum(1, 2);
        System.out.println(sum);

        double naN = Double.NaN;
        System.out.println(naN);

        boolean finite = Double.isFinite(-1.1); // 无穷数
        System.out.println(finite);
        boolean infinite = Double.isInfinite(2.01);
        System.out.println(infinite);
    }
}
