package yingdg.exercise.se._enum;

import java.util.Arrays;

/**
 * Created by yingdg on 2017/8/9.
 */
public class SimpleEnumTest {
    public static void main(String[] args) {
        System.out.println(项目组.项目经理);
        System.out.println(项目组.项目主管);
        System.out.println(项目组.开发工程师);

        项目组[] values = 项目组.values();
        System.out.println(Arrays.toString(values));
    }
}
