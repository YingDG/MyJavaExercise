package yingdg.exercise.se.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author zdm
 * created in 2018/5/21 下午5:43
 */
public class StreamMain {
    private static List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 5, 4, 7, 5, 3, 2));

    public static void main(String[] args) {
        Integer i1 = integers.parallelStream().findFirst().get();
        System.out.println(i1);

        integers.parallelStream().limit(3).forEach(System.out::print);
        System.out.println();

        integers.stream().sorted().forEach(System.out::print);
        System.out.println();

        integers.stream().filter(e -> e < 6).sorted().distinct().forEach(System.out::print);
        System.out.println();

        String i2 = integers.stream().map(e -> e.toString()).collect(Collectors.joining(", "));
        System.out.println(Objects.toString(i2));

        LongSummaryStatistics statistics = integers.stream().mapToLong(e -> e.longValue()).summaryStatistics();
        System.out.println(Objects.toString(statistics));

    }

}
