package yingdg.exercise.se._bigdecimal;

import java.math.BigDecimal;

/**
 * Created by zdm on 2018/3/20.
 */
public class BigDecimalTest {
    public static void main(String[] args) throws IllegalAccessException {
        // 构造函数
        System.out.println(new BigDecimal(1.22)); // 1.2199999999999999733546474089962430298328399658203125
        System.out.println(new BigDecimal("1.22")); // 1.22

        // 运算
        System.out.println(BigDecimalUtil.add(1, 2));
        System.out.println(BigDecimalUtil.sub(1, 2));
        System.out.println(BigDecimalUtil.multi(2, 3));
        System.out.println(BigDecimalUtil.divide(2, 4, 4));
    }
}
