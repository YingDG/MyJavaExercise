package yingdg.exercise.se.pid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yingdg on 2018/1/11 0011.
 */
public class CloseLinuxJavaProcess {

    public static void main(String[] args) {
        /*
        java -jar test.jar
         */
        // String PID = getPID("java -jar " + args[0] + ".jar"); // args[0]为jar包名
        String PID = getPID("java -jar " + args[0]); // args[0]为jar包名.jar
        closeLinuxProcess(PID);
    }

    public static String getPID(String command) {
        BufferedReader reader = null;
        try {
            //显示所有进程
            Process process = Runtime.getRuntime().exec("ps -ef");
            reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                // 遍历进程名
                if (line.contains(command)) {
                    System.out.println("相关信息 -----> " + command);
                    String[] strs = line.split("\\s+");
                    return strs[1];
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static void closeLinuxProcess(String Pid) {
        Process process = null;
        BufferedReader reader = null;
        try {
            //杀掉进程
            process = Runtime.getRuntime().exec("kill -9 " + Pid);
            reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("kill PID return info -----> " + line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (process != null) {
                process.destroy();
            }

            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
