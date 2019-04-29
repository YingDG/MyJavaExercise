package yingdg.exercise.se.basicdatatype;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author YingDG
 * created in 2019/4/29 上午10:58
 */
public class StringMain {
    public static void main(String[] args) {
        String join = String.join("-", "A", "B");
        System.out.println(join);

        String join1 = String.join("-", "A", "B", "c");
        System.out.println(join1);

        String join2 = String.join("-", Stream.of("A", "b", "1").collect(Collectors.toList()));
        System.out.println(join2);
    }
}
