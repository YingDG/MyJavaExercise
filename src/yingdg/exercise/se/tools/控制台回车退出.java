package yingdg.exercise.se.tools;

import java.io.IOException;

/**
 * @author YingDG
 * created in 2019/5/22 11:16 AM
 */
public class 控制台回车退出 {
    public static void main(String[] args) {
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
