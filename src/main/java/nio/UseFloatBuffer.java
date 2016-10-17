package nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by harlenzhang on 16/10/14.
 */
public class UseFloatBuffer {
    public static void main(String[] args) throws IOException {
        FileInputStream fin = new FileInputStream("test.txt");
        FileChannel fc = fin.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        fc.read(buffer);
    }
}
