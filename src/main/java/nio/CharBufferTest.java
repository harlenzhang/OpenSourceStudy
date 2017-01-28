package nio;

import java.nio.CharBuffer;

/**
 * Created by harlenzhang on 2017/1/25.
 */
public class CharBufferTest {
    private static String [] strings = {
            "A random string value",
            "The product of an infinite number of monkeys",
            "Hey hey we're the Monkees",
            "Opening act for the Monkees: Jimi Hendrix",
            "'Scuse me while I kiss this fly", // Sorry Jimi ;-)
    };
    private static int index = 0;
    public static void main(String[] args) {

        CharBuffer charBuffer = CharBuffer.allocate(100);
        while (fillBuffer(charBuffer)){
            charBuffer.flip();
            charBuffer.compact();
            System.out.println("current buffer has " + charBuffer.remaining());
            charBuffer.clear();
        }
        System.out.println(charBuffer);
        System.out.println(charBuffer.remaining());
    }

    private static void consumeBuffer(CharBuffer buffer){
        while (buffer.hasRemaining())
            System.out.println(buffer.get());
    }

    private static boolean fillBuffer(CharBuffer buffer){
        index ++;
        if (index >= strings.length)
            return false;
        String string = strings[index];
        for (char c : string.toCharArray()){
            buffer.put(c);
        }
        return true;
    }

}
