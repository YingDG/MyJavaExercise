package yingdg.exercise.se.net;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author YingDG
 * created in 2019/6/24 11:10 AM
 */
public class NetMain {
    public static void main(String[] args) {
        /*
        URL类
         */
        try {
            URL url = new URL("http://www.runoob.com/html/html-tutorial.html");
            System.out.println("URL 是 " + url.toString());
            System.out.println("协议是" + url.getProtocol());
            System.out.println("文件名是" + url.getFile());
            System.out.println("主机是" + url.getHost());
            System.out.println("路径是" + url.getPath());
            System.out.println("端口号是" + url.getPort());
            System.out.println("默认端口号是" + url.getDefaultPort());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        /*
        ServerSocket类，Socket类
         */
    }
}
