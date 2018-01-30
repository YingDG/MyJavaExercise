package yingdg.exercise.se.stringtool;

import java.util.Arrays;

/**
 * Created by yingdg on 2017/8/14.
 */
public class 查找数组中的第一个重复元素 {

    public static Object findDuplicateElement(Object[] objs) {
        Object[] clone = objs.clone();

        Arrays.sort(objs);
        for (int i = 0; i < objs.length - 1; i++) {
            if (objs[i].equals(objs[i + 1])) {
                return objs[i];
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Object[] ints = {1, 3, 2, 4, 3};
        System.out.println(findDuplicateElement(ints));
    }
}
