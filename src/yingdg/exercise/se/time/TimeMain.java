package yingdg.exercise.se.time;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;

/**
 * @author yingdg
 * @version 1.0 2019/04/03
 */
public class TimeMain {
    public static void main(String[] args) {
        // 当前时间
        Instant now = Instant.now();
        System.out.println(new Date(now.toEpochMilli()));

        LocalDate now1 = LocalDate.now();
        System.out.println(now1);

        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now2.withNano(0));

        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock);

        // enum
        int value = Month.JANUARY.getValue();
        System.out.println(value);
    }
}
