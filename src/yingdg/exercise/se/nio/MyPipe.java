package yingdg.exercise.se.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * Created by yingdg on 2017/7/26.
 */
public class MyPipe {
    /*
    管道是2个线程之间的单向数据连接。
    Pipe有一个source通道和一个sink通道。数据会被写到sink通道，从source通道读取。
     */
    public static void main(String[] args) throws IOException {
        Pipe pipe = Pipe.open();

        // 向管道写数据
        Pipe.SinkChannel sink = pipe.sink();
        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        buf.put("hello".getBytes());
        buf.flip();
        while (buf.hasRemaining()) {
            sink.write(buf);
        }

        // 从管道读数据
        Pipe.SourceChannel source = pipe.source();
        ByteBuffer buf2 = ByteBuffer.allocate(48);
        source.read(buf2);
        while (buf2.hasRemaining()) {
            System.out.print((char) buf2.get());
        }
    }
}
