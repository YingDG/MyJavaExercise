package yingdg.exercise.se.pid;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * Created by yingdg on 2018/1/11 0011.
 */
public class KillPid {
    public static void main(String[] args) {
        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
        String name = runtime.getName(); // pid + 主机名
        System.out.println("当前进程的标识为：" + name);
        int index = name.indexOf("@");
        if (index != -1) {
            int pid = Integer.parseInt(name.substring(0, index));
            System.out.println("当前进程的PID为：" + pid);
        }

        /*
        Linux可以使用kill -9 pid命令关闭java程序
         */

        try {
            //这里休息60秒，是为了在windows管理器查看该应用程序的进程PID
            Thread.sleep(60 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
