package tomcat.Socket;

import java.io.*;
import java.net.Socket;

/**
 * Created by harlenzhang on 16/6/2.
 */
public class LocalSocketTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream os = socket.getOutputStream();
        PrintWriter out = new PrintWriter(os, true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        out.println("test");
        out.println("Host: localhost:8088");
        out.println("Connection: Close");

        boolean loop = true;
        StringBuffer sb = new StringBuffer(8096);
        while (loop){
            if (in.ready()){
                int i = 0;
                while (i!=-1) {
                    i = in.read(); sb.append((char) i);
                }
                loop = false; }
            Thread.currentThread().sleep(50);
            }
        System.out.println(sb.toString());
        socket.close();
        }

    }

