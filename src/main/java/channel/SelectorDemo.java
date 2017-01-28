package channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by harlenzhang on 2017/1/27.
 */
public class SelectorDemo {
    public static void main(String[] args) throws Exception {
        int port = 8000;
        ServerSocketChannel channel = ServerSocketChannel.open();
        ServerSocket serverSocket = channel.socket();
        Selector selector = Selector.open();
        serverSocket.bind(new InetSocketAddress(port));
        channel.configureBlocking(false);
        channel.register(selector, SelectionKey.OP_ACCEPT);

        while (true){
            int n = selector.select();
            if (n == 0){
                System.out.println("not blocking");
                continue;

            }


            for (SelectionKey key : selector.selectedKeys()){
                if (key.isAcceptable()){
                    ServerSocketChannel server = (ServerSocketChannel)key.channel();
                    SocketChannel socketChannel = server.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }
                if (key.isReadable()){
                    System.out.println("reading data from socket");
                }
                selector.selectedKeys().remove(key);
            }

        }
    }
}
