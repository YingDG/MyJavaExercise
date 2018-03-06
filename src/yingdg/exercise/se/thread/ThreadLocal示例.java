package yingdg.exercise.se.thread;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zdm on 2017/1/6.
 */
public class ThreadLocal示例 {
    /*
     * 高并发使用ThreadLocal类保证线程安全
     */
    private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    private ThreadLocal示例() {

    }

    public static Date parse(String dateStr) throws ParseException {
        return threadLocal.get().parse(dateStr);
    }

    public static String format(Date date) {
        return threadLocal.get().format(date);
    }

    public static void main(String[] args) {
        String date = format(new Date());
        System.out.println(date);
        try {
            Date date1 = parse(date);
            System.out.println(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
