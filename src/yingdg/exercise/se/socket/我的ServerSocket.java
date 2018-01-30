package yingdg.exercise.se.socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by yingdg on 2017/7/20.
 */
public class 我的ServerSocket {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9999);
        Socket client = server.accept();

        // 获取客户端的输入输出
        Scanner scanner = new Scanner(client.getInputStream());
        PrintStream out = new PrintStream(client.getOutputStream());

        while (true) {
            if (scanner.hasNext()) {
                // 接收与回应
                String str = scanner.next().trim();
                out.println("ECHO: " + str);

                // 退出
                if ("quit".equalsIgnoreCase(str)) {
                    out.println("bye");
                    break;
                }
            }
        }

        scanner.close();
        client.close();
        server.close();
    }
}
