package yingdg.exercise.se.datetime;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

/**
 * @author zdm
 * created in 2018/6/5 下午2:18
 */
public class CalendarMain {
    public static void main(String[] args) {
        Set<String> availableCalendarTypes = Calendar.getAvailableCalendarTypes();
        System.out.println(availableCalendarTypes);

        Locale[] availableLocales = Calendar.getAvailableLocales();
        System.out.println(Arrays.toString(availableLocales));

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        Date date = calendar.getTime();
        System.out.println(date);
    }
}
