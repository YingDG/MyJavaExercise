package yingdg.exercise.se.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by yingdg on 2017/8/4.
 */
public class MyServerSocketChannelTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        // 声明ServerSocket
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // serverSocketChannel.socket().bind(new InetSocketAddress(9999));
        serverSocketChannel.bind(new InetSocketAddress(9999));
        serverSocketChannel.configureBlocking(false);
        System.out.println("listener on port: 9999");

        // 声明ByteBuffer
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        byteBuffer.order(ByteOrder.BIG_ENDIAN);

        // 声明Selector
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        /*
        无阻塞io是使用单线程或者只使用少量的多线程，每个连接共用一个线程，
        当处于等待（没有事件）的时候线程资源可以释放出来处理别的请求，通过事件驱动模型当有accept/read/write等事件发生后通知（唤醒）主线程分配资源来处理相关事件。

        Selector就是在该模型中事件的观察者，可以将多个SocketChannel的事件注册到一个Selector上，
        当没有事件发生时Selector处于阻塞状态，当SocketChannel有accept/read/write等事件发生时唤醒Selector。
        通过seletor，可以实现单线程操作多线程的效果.。
         */

        int remoteClientNum = 0;
        // 接收消息
        while (true) {
            // int select = selector.select(1000); // 定时等待唤醒
            // selector没有被唤醒，跳过
            if (selector.select() == 0) {
                continue;
            }
            // selector.wakeup(); // 主动唤醒

            Iterator<SelectionKey> ite = selector.selectedKeys().iterator();
            while (ite.hasNext()) {
                SelectionKey key = ite.next();

                // a connection was accepted by a ServerSocketChannel.
                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel channel = server.accept();
                    channel.configureBlocking(false);
                    channel.register(selector, SelectionKey.OP_READ);
                    // print info
                    remoteClientNum++;
                    System.out.println("online client num=" + remoteClientNum);

                    // 发送消息给客户端
                    byteBuffer.clear();
                    byteBuffer.put("hello client!\r\n".getBytes());
                    byteBuffer.flip();
                    channel.write(byteBuffer);
                }

                // a channel is ready for reading
                if (key.isReadable()) {
                    SocketChannel client = (SocketChannel) key.channel();
                    byteBuffer.clear();

                    int count;
                    while ((count = client.read(byteBuffer)) > 0) {
                        byteBuffer.flip(); // Make buffer readable

                        // Send the data; don't assume it goes all at once
                        while (byteBuffer.hasRemaining()) {
                            System.out.print((char) byteBuffer.get());
                            // client.write(byteBuffer);
                        }
                        Thread.sleep(1000);
                        byteBuffer.clear();
                        byteBuffer.put((System.currentTimeMillis() + " server accepted!\r\n").getBytes());
                        byteBuffer.flip();
                        client.write(byteBuffer);

                        byteBuffer.clear(); // Empty buffer
                    }

                    if (count < 0) {
                        client.close();
                    }
                }

                ite.remove(); // must
            }
        }
    }
}
