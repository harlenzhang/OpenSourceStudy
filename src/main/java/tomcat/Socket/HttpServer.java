package tomcat.Socket;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by harlenzhang on 16/6/2.
 */
public class HttpServer {
    public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "webroot";

    public static final String SHUTDOWN_COMMAND="/SHUTDOWN";

    private boolean shutdown = false;

    private void await(){
        try {
            ServerSocket serverSocket = new ServerSocket(8888, 2, InetAddress.getByName("127.0.0.1"));
            while (!shutdown){
            Socket client = serverSocket.accept();
                OutputStream os = client.getOutputStream();
                InputStream inputStream = client.getInputStream();
                BaseRequest request = new BaseRequest(inputStream);
                request.parse();

                BaseResponse response = new BaseResponse(os);
                response.setRequest(request);
                response.sendStaticResource();
                client.close();

                shutdown = request.getUri().equals(SHUTDOWN_COMMAND);


            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
    public static void main(String[] args) throws IOException {
        HttpServer server = new HttpServer();
        server.await();
    }
}
