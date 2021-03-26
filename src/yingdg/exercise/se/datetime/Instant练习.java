package yingdg.exercise.se.datetime;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author YingDG
 * created in 2021/3/26 9:53 AM
 */
public class Instant练习 {

    public static void main(String[] args) {
        // 表示时间线的一个确切点，默认0时区
        Instant now = Instant.now();
        System.out.println(now);
        System.out.println(now.toEpochMilli()); // 毫秒数

        // 计算
        Instant later = now.plusSeconds(180);
        System.out.println(later);
        Instant earlier = now.minusMillis(1000);
        System.out.println(earlier);

        Instant now2 = Instant.ofEpochMilli(new Date().getTime());
        System.out.println(now2.atZone(ZoneId.systemDefault()));
    }

}
