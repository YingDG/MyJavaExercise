package yingdg.exercise.se.datetime;

import java.time.ZoneId;
import java.util.Set;
import java.util.TimeZone;

/**
 * @author YingDG
 * created in 2021/3/26 9:35 AM
 */
public class ZoneId练习 {

    public static void main(String[] args) {
        // 时区操作类
        ZoneId shanghaiZoneId = ZoneId.of("Asia/Shanghai");
        System.out.println(shanghaiZoneId);
        ZoneId systemZoneId = ZoneId.systemDefault();
        System.out.println(systemZoneId);

        System.out.println("---------------------------");

        // 获取所有的区域/城市
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.forEach(System.out::println);

        System.out.println("---------------------------");

        // TimeZone转为ZoneId
        ZoneId zoneId = TimeZone.getDefault().toZoneId();
        System.out.println(zoneId);
    }

}
