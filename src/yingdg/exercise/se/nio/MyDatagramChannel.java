package yingdg.exercise.se.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * Created by yingdg on 2017/7/26.
 */
public class MyDatagramChannel {
    public static void main(String[] args) throws IOException {
        DatagramChannel channel = DatagramChannel.open();
        channel.socket().bind(new InetSocketAddress(9999));
        // 发送数据
        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        buf.put("hello".getBytes());
        buf.flip();
        channel.send(buf, new InetSocketAddress("localhost", 9999));

        DatagramChannel channel2 = DatagramChannel.open();
        channel2.connect(new InetSocketAddress("localhost", 9999));
        // 接收数据
        ByteBuffer buf2 = ByteBuffer.allocate(48);
        buf2.clear();
        channel2.receive(buf2);
        while (buf2.hasRemaining()) {
            System.out.println((char) buf2.get());
        }
    }
}
