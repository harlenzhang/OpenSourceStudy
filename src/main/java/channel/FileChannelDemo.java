package channel;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by harlenzhang on 2017/1/26.
 */
public class FileChannelDemo {
    public static void main(String[] args) throws IOException {
        String filePath = "/Users/harlenzhang/Documents/projects/OpenSourceStudy/src/main/java/groovy/groovycode/Foo.groovy";
        RandomAccessFile file = new RandomAccessFile(filePath, "r");
        FileChannel channel = file.getChannel();
        MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, 100);
        CharBuffer charBuffer = buffer.asCharBuffer();
        System.out.println(buffer.isLoaded());
        System.out.println(buffer.isDirect());
        while (charBuffer.hasRemaining())
            System.out.println(charBuffer.get());


    }
}
