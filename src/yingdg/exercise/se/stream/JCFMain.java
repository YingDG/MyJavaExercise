package yingdg.exercise.se.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zdm
 * created in 2018/10/22 下午1:24
 */
public class JCFMain {
    private static List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 5, 4, 7, 5, 3, 2));
    private static List<Integer> integers2 = new ArrayList<>(Arrays.asList(11, 21, 51, 41, 71, 51, 31, 21));

    public static void main(String[] args) {
        integers.sort(Comparator.comparingInt(e -> (int) e).reversed());
        System.out.println(integers);

        List<Integer> collect = integers2.parallelStream()
//                .sorted(Comparator.comparingInt(Integer::intValue))
                .sorted(Comparator.comparing(Integer::intValue).reversed())
                .collect(Collectors.toList());
        System.out.println(collect);


    }

}
