package yingdg.exercise.se.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.SocketChannel;

/**
 * Created by yingdg on 2017/8/4.
 */
public class MySocketChannelTest {
    public static void main(String[] args) throws IOException {
        // 声明Socket
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 9999));
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.order(ByteOrder.BIG_ENDIAN);

        // 接收消息
        while (true) {
            byteBuffer.clear();

            int count;
            while ((count = socketChannel.read(byteBuffer)) > 0) {
                byteBuffer.flip();

                while (byteBuffer.hasRemaining()) {
                    System.out.print((char) byteBuffer.get());
                }

                // 发送消息
                byteBuffer.clear();
                byteBuffer.put((System.currentTimeMillis() + " send data to server\r\n").getBytes());
                byteBuffer.flip();
                socketChannel.write(byteBuffer);

                // 清除
                byteBuffer.clear();
            }
        }
    }
}
