package channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by harlenzhang on 2017/1/26.
 */
public class SocketChannelDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 1234;
        ByteBuffer buffer = ByteBuffer.wrap(new String("Hello I must be going").getBytes());
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
         socketChannel.socket().bind(new InetSocketAddress(port));
        socketChannel.configureBlocking(true);

        while (true){
            System.out.println("waiting for connection");
            SocketChannel sc = socketChannel.accept();
            System.out.println("is connection pending" + sc.isConnectionPending());
            if (sc == null){
                Thread.currentThread().sleep(1000);
            }else {
                System.out.println("Incoming connection from " + sc.socket().getInetAddress());
                buffer.rewind();
                sc.write(buffer);
                System.out.println(sc);
                sc.close();
            }
        }

    }
}
