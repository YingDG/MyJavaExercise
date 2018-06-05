package yingdg.exercise.se.datetime;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @author zdm
 * created in 2018/6/5 下午2:14
 */
public class DateMain {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now().minusDays(1);
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(zoneId);
        Date date = Date.from(zonedDateTime.toInstant());
        System.out.println(date);
    }
}
