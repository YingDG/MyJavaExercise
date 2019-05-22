package yingdg.exercise.se.tools;

import java.util.concurrent.TimeUnit;

/**
 * @author YingDG
 * created in 2019/5/22 11:14 AM
 */
public class Sleep几秒 {
    public static void main(String[] args) {
        try {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("sleep");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
