package yingdg.exercise.se.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by yingdg on 2017/7/26.
 */
public class MyScatterAndGather {
    /*
    分散（scatter）从Channel中读取是指在读操作时将读取的数据写入多个buffer中。
    因此，Channel将从Channel中读取的数据“分散（scatter）”到多个Buffer中。

    聚集（gather）写入Channel是指在写操作时将多个buffer的数据写入同一个Channel，
    因此，Channel 将多个Buffer中的数据“聚集（gather）”后发送到Channel。

    scatter / gather经常用于需要将传输的数据分开处理的场合，
    例如传输一个由消息头和消息体组成的消息，你可能会将消息体和消息头分散到不同的buffer中，这样可以方便的处理消息头和消息体。
     */
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile(
                "E:\\IdeaProjects\\MyGroovyExercise\\src\\main\\java\\yingdg\\exercise\\nio\\ScatterAndGatherText", "r");
        FileChannel channel = file.getChannel();

        ByteBuffer headBuffer = ByteBuffer.allocate(10);
        ByteBuffer bodyBuffer = ByteBuffer.allocate(20);
        ByteBuffer[] buffers = {headBuffer, bodyBuffer};
        // read data into buffers
        long read = channel.read(buffers);
        System.out.println(read);

//        ByteBuffer headBuffer = ByteBuffer.allocate(10);
//        ByteBuffer bodyBuffer = ByteBuffer.allocate(20);
//        ByteBuffer[] buffers = {headBuffer, bodyBuffer};
        // write data into buffers
//        long read = channel.write(buffers);
//        System.out.println(read);
    }
}
