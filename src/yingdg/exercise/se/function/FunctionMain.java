package yingdg.exercise.se.function;

import java.util.Objects;
import java.util.function.Function;

/**
 * @author YingDG
 * created in 2019/4/16 下午7:27
 */
public class FunctionMain {
    public static void main(String[] args) {
        Function f = Objects::toString;

        Function<Integer, String> function = new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return integer.toString();
            }
        };

        Function<Integer, String> compose = Function.identity()
                .andThen(s -> s + s.getClass().getSimpleName()) // after
                .compose(function); // before
        System.out.println(compose.apply(1));
    }
}
