package yingdg.exercise.se.datetime;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author YingDG
 * created in 2021/3/26 10:20 AM
 */
public class DateTimeFormatter练习 {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        System.out.println(formatter.format(ZonedDateTime.now()));
    }

}
