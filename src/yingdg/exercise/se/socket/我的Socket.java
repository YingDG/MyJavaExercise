package yingdg.exercise.se.socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by yingdg on 2017/7/20.
 */
public class 我的Socket {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 9999);

        // 客户端输入
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        PrintStream out = new PrintStream(client.getOutputStream());
        // 获取客户端输出
        Scanner scanner = new Scanner(client.getInputStream()).useDelimiter("\n");

        while (true) {
            System.out.println("请输入：");

            if (input.hasNext()) {
                // 发送
                String str = input.next().trim();
                out.println(str);
                // 接收
                if (scanner.hasNext()) {
                    System.out.println(scanner.next());
                }

                // 退出
                if ("quit".equalsIgnoreCase(str)) {
                    System.out.println("退出。");
                    break;
                }
            }
        }

        input.close();
        out.close();
        scanner.close();
        client.close();
    }
}
