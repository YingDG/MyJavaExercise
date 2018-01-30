package yingdg.exercise.se.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * Created by yingdg on 2017/7/26.
 */
public class MyChannelTransform {
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile(
                "E:\\IdeaProjects\\MyGroovyExercise\\src\\main\\java\\yingdg\\exercise\\nio\\ChannelText", "r");
        FileChannel channel = file.getChannel();

        RandomAccessFile file2 = new RandomAccessFile(
                "E:\\IdeaProjects\\MyGroovyExercise\\src\\main\\java\\yingdg\\exercise\\nio\\ChannelTransfomText", "rw");
        FileChannel channel2 = file2.getChannel();
        // 复制文件内容
        long l = channel2.transferFrom(channel, 0, channel.size());
        System.out.println(l);
//        long l2 = channel.transferTo(0, channel.size(), channel2);
//        System.out.println(l2);
    }
}
