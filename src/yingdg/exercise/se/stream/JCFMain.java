package yingdg.exercise.se.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.stream.Collectors;

/**
 * @author zdm
 * created in 2018/10/22 下午1:24
 */
public class JCFMain {
    private static List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 5, 4, 7, 5, 3, 2));
    private static List<Integer> integers2 = new ArrayList<>(Arrays.asList(11, 21, 51, 41, 71, 51, 31, 21));
    private static Map<Integer, String> map;

    static {
        map = new HashMap<>();
        map.put(1, "a");
        map.put(3, "c");
        map.put(2, "b");
    }

    /*
    使用lamda表达式生成方法，而不是内部类
     */
    public static void main(String[] args) {
        /*
        Collection
         */

        //
        integers.sort(Comparator.comparingInt(e -> (int) e).reversed());
        System.out.println(integers);

        //
        List<Integer> collect = integers2.parallelStream()
//                .sorted(Comparator.comparingInt(Integer::intValue))
                .sorted(Comparator.comparing(Integer::intValue).reversed())
                .collect(Collectors.toList());
        System.out.println(collect);

        //
        integers.removeIf(e -> e.equals(1));
        System.out.println(integers);

        //
        Spliterator<Integer> spliterator = integers.spliterator();
        int characteristics = spliterator.characteristics();
        System.out.println(characteristics);

        // 条件替换
        integers2.replaceAll(e -> 11);
        System.out.println(integers2);

        /*
        Map
         */

        //
        map.forEach((i, s) -> System.out.println(i + s));

        //
        String aNull = map.getOrDefault(1, "null");
        System.out.println(aNull);

        // 条件替换所有value
        map.replaceAll((i, s) -> i + s);
        System.out.println(map);

        //
        map.putIfAbsent(4, "d");
        System.out.println(map);

        // 添加entry时没有value，则按key计算
        map.computeIfAbsent(5, Object::toString);
        System.out.println(map);

        // 按key条件计算已有entry的value值
        map.computeIfPresent(5, (i, s) -> i + s);
        System.out.println(map);

        // 已有entry补充处理，未有entry添加值
        map.merge(6, "c", (s, s2) -> s + s2);
        System.out.println(map);
    }

}
