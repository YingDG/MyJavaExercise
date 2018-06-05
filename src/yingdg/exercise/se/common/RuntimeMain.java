package yingdg.exercise.se.common;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.IOException;

/**
 * @author zdm
 * created in 2018/6/5 下午2:04
 */
public class RuntimeMain {
    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();

        int availableProcessors = runtime.availableProcessors();
        System.out.println("availableProcessors:" + availableProcessors);

        Process process = runtime.exec("java -version");
        byte[] bytes = new byte[32];
        process.getOutputStream().write(bytes);
        System.out.println(new String(bytes));

        long freeMemory = runtime.freeMemory();
        System.out.println("freeMemory:" + freeMemory);
        long maxMemory = runtime.maxMemory();
        System.out.println("maxMemory:" + maxMemory);
        long totalMemory = runtime.totalMemory();
        System.out.println("totalMemory:" + totalMemory / 1024 / 1024);
    }
}
