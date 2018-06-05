package yingdg.exercise.se.common;

/**
 * @author zdm
 * created in 2018/6/5 下午2:37
 */
public class BooleanTest {
    public static void main(String[] args) {
        Boolean aTrue = Boolean.TRUE;
        Boolean aFalse = Boolean.FALSE;
        Class<Boolean> booleanClass = Boolean.TYPE;

        boolean b = Boolean.parseBoolean("tRue");
        System.out.println(b);
        // 获取系统属性中的boolean结果值
        boolean b1 = Boolean.getBoolean("java.runtime.name");
        System.out.println(b1);

        boolean logicalAnd = Boolean.logicalAnd(true, false);
        System.out.println(logicalAnd);

        boolean logicalOr = Boolean.logicalOr(false, true);
        System.out.println(logicalOr);

        int compare = Boolean.compare(false, true);
        System.out.println(compare);

        // 异或
        boolean logicalXor = Boolean.logicalXor(true, true);
        System.out.println(logicalXor);
    }
}
