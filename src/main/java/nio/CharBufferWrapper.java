package nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by harlenzhang on 2017/1/25.
 */
public class CharBufferWrapper {
    public static void main(String[] args) {
        char[] chars = {'a','b','c','d'};
        CharBuffer buffer = CharBuffer.wrap(chars, 0, 3);
        while (buffer.hasRemaining()){
            System.out.println(buffer.get());
        }
        System.out.println(buffer.limit());
        buffer.flip();
    }
}
