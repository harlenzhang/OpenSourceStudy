package channel.async;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * Created by harlenzhang on 2017/1/28.
 */
public class FtpClient {
    AsynchronousSocketChannel channel;

    public static void main(String[] args) throws Exception {
        AsynchronousSocketChannel channel = AsynchronousSocketChannel.open();
        channel.connect(new InetSocketAddress("112.74.133.88", 22), channel, new CompletionHandler<Void, AsynchronousSocketChannel>() {
            public void completed(Void result, AsynchronousSocketChannel attachment) {
                FtpClient client = new FtpClient();
            }

            public void failed(Throwable exc, AsynchronousSocketChannel attachment) {
            exc.printStackTrace();
            }
        });
        System.in.read();

    }

    public void start(AsynchronousSocketChannel channel){
        this.channel = channel;
        ByteBuffer buffer = ByteBuffer.allocate(128);
        channel.read(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            public void completed(Integer result, ByteBuffer attachment) {
                if (result > 0){
                    int position = attachment.position() - 1;

                }
            }

            public void failed(Throwable exc, ByteBuffer attachment) {

            }
        });
    }
}
