package yingdg.exercise.se.function;

import java.util.function.Predicate;

/**
 * @author YingDG
 * created in 2019/4/16 下午7:14
 */
public class PredicateMain {
    public static void main(String[] args) {
        Predicate<String> predicate = Predicate.isEqual("hello");
        System.out.println(predicate.test("hello"));

        Predicate<String> negate = predicate.negate();
        System.out.println(negate.test("hello"));
    }
}
