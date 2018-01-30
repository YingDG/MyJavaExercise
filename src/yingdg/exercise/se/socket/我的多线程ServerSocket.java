package yingdg.exercise.se.socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by yingdg on 2017/7/20.
 */
class Socket线程 implements Runnable {
    private Socket client;

    public Socket线程(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            // 获取客户端的输入输出
            Scanner scanner = new Scanner(client.getInputStream());
            PrintStream out = new PrintStream(client.getOutputStream());

            while (true) {
                if (scanner.hasNext()) {
                    String str = scanner.next().trim();
                    out.println("ECHO: " + str);

                    if ("quit".equalsIgnoreCase(str)) {
                        out.println("bye");
                        break;
                    }
                }
            }

            scanner.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

public class 我的多线程ServerSocket {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(9999);

        // 每个客户端连接都启动一个线程接收
        while (true) {
            try {
                Socket client = server.accept();
                new Thread(new Socket线程(client)).start();
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }

        server.close();
    }
}
