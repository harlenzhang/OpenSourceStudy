package channel;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by harlenzhang on 2017/1/28.
 */
public class BlockingIODemo {
    public static void main(String[] args) throws Exception{
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.configureBlocking(false);
        ServerSocket socket = socketChannel.socket();
        socket.bind(new InetSocketAddress(8000));
        while(true){
            System.out.println("waiting for request");
            Thread.currentThread().sleep(5000);
            SocketChannel channel = socketChannel.accept();
            Socket client = channel.socket();
            System.out.println(client);
            long start = System.currentTimeMillis();
            System.out.println("processing request");
            Thread.currentThread().sleep(5000);
            long end = System.currentTimeMillis();
            System.out.println("the processing time is " + (end - start));
        }

    }
}
