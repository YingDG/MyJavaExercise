package yingdg.exercise.se.function;

import java.util.Optional;

/**
 * @author zdm
 * created in 2018/5/21 下午6:22
 */
public class OptionalMain {
    private static Optional<String> opt = Optional.ofNullable("Value");

    public static void main(String[] args) {
        System.out.println(opt.get());
    }

}
