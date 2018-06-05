package yingdg.exercise.se.common;

import java.util.Comparator;

/**
 * @author zdm
 * created in 2018/6/5 下午2:29
 */
public class StringTest {
    public static void main(String[] args) {
        // 字符串大小写敏感排序
        Comparator<String> caseInsensitiveOrder = String.CASE_INSENSITIVE_ORDER;

        // C语言输出占位符
        String format = String.format("hello,%s", "world");
        System.out.println(format);

        String join = String.join("-", "hello", "world");
        System.out.println(join);

        String copyValueOf = String.copyValueOf(new char[]{'a', 'c'});
        System.out.println(copyValueOf);
    }
}
