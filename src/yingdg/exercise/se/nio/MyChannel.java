package yingdg.exercise.se.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by yingdg on 2017/7/26.
 */
public class MyChannel {
    /*
    channel -> buffer -> channel
     */
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile(
                "E:\\IdeaProjects\\MyGroovyExercise\\src\\main\\java\\yingdg\\exercise\\nio\\ChannelText", "r");
        FileChannel channel = file.getChannel();

        // create buffer with capacity of 32 bytes
        ByteBuffer buffer = ByteBuffer.allocate(32);
        System.out.println("capacity: " + buffer.capacity());
        System.out.println("limit: " + buffer.limit());
        System.out.println("position: " + buffer.position());

        // 1.写入数据到Buffer
        int read = channel.read(buffer); // 返回读取的字符数？
        while (read != -1) {
            System.out.println("字符数: " + read);

            // 2. make buffer ready for read
            /*
            flip方法将Buffer从写模式切换到读模式。
            调用flip()方法会将position设回0，并将limit设置成之前position的值
             */
            buffer.flip();
//            System.out.println(buffer.capacity());
//            System.out.println(buffer.limit());
//            System.out.println(buffer.position());

            /*
            Buffer.rewind()将position设回0，所以你可以重读Buffer中的所有数据。
            limit保持不变，仍然表示能从Buffer中读取多少个元素（byte、char等）。
             */
            // buffer.rewind();

            /*
            通过调用Buffer.mark()方法，可以标记Buffer中的一个特定position。
            之后可以通过调用Buffer.reset()方法恢复到这个position。
             */
            // buffer.mark();
            // buffer.reset();

            while (buffer.hasRemaining()) {
                // 3.从Buffer中读取数据，第次读取1个字节
                char c = (char) buffer.get();
                System.out.print(c);
            }

            // 4. 调用clear()方法或者compact()方法，准备重新读取下个字节
            /*
            如果调用的是clear()方法，position将被设回0，limit被设置成 capacity的值。
            换句话说，Buffer 被清空了。Buffer中的数据并未清除，只是这些标记告诉我们可以从哪里开始往Buffer里写数据。
            如果Buffer中有一些未读的数据，调用clear()方法，数据将“被遗忘”，意味着不再有任何标记会告诉你哪些数据被读过，哪些还没有。
            如果Buffer中仍有未读的数据，且后续还需要这些数据，但是此时想要先先写些数据，那么使用compact()方法。
             */
            buffer.clear();
            // buffer.compact();

            /*
            equals()与compareTo()方法

            equals()
            当满足下列条件时，表示两个Buffer相等：
            1.有相同的类型（byte、char、int等）。
            2.Buffer中剩余的byte、char等的个数相等。
            3.Buffer中所有剩余的byte、char等都相同。
            equals只是比较Buffer的一部分，不是每一个在它里面的元素都比较。实际上，它只比较Buffer中的剩余元素。

            compareTo()方法
            比较两个Buffer的剩余元素(byte、char等)， 如果满足下列条件，则认为一个Buffer“小于”另一个Buffer：
            1.第一个不相等的元素小于另一个Buffer中对应的元素 。
            2.所有元素都相等，但第一个Buffer比另一个先耗尽(第一个Buffer的元素个数比另一个少)。

             */

            // 读取下个部分
            read = channel.read(buffer);
        }

        file.close();
    }
}
