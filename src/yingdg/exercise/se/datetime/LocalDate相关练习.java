package yingdg.exercise.se.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author YingDG
 * created in 2021/3/26 9:45 AM
 */
public class LocalDate相关练习 {

    public static void main(String[] args) {
        // 均无时区属性
        LocalDateTime localDateTime = LocalDateTime.now();

        ZoneId shanghaiZoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, shanghaiZoneId);
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime.toInstant());

        // 时区偏移
        ZoneOffset zoneOffset = ZoneOffset.of("+09:00");
        OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, zoneOffset);
        System.out.println(offsetDateTime);

        LocalDate localDate = LocalDate.now();
        ZonedDateTime zonedDateTime2 = ZonedDateTime.of(localDate, LocalTime.of(0, 0, 0),
                ZoneId.systemDefault());
        System.out.println(zonedDateTime2);

        // 计算
        LocalDate plus = localDate.plus(1, ChronoUnit.DAYS);
        System.out.println(plus);
        System.out.println(LocalTime.now().plusHours(1).getHour());
    }

}
