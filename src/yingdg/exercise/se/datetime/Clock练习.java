package yingdg.exercise.se.datetime;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.Date;
import java.util.Locale;

/**
 * @author YingDG
 * created in 2021/3/26 10:01 AM
 */
public class Clock练习 {

    public static void main(String[] args) {
        // 当前日期和时间
        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock); // SystemClock[Asia/Shanghai]
        System.out.println(clock.millis());

        // 转换为Date类
        Date now = Date.from(clock.instant()); // 关键
        System.out.println(now);
        System.out.println(Locale.getDefault()); // Locale.CHINA = Locale.SIMPLIFIED_CHINESE
        // 非线程安全
        System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.CHINA).format(now));
    }

}
