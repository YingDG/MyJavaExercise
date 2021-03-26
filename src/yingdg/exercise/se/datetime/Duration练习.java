package yingdg.exercise.se.datetime;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * @author YingDG
 * created in 2021/3/26 10:23 AM
 */
public class Duration练习 {

    public static void main(String[] args) {
        Duration between = Duration.between(Instant.ofEpochSecond(10), Instant.ofEpochSecond(2));
        System.out.println(between.getSeconds());
        System.out.println(between.get(ChronoUnit.SECONDS));
    }

}
