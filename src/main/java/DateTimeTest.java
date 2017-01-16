import org.joda.time.DateTime;
import org.springframework.format.datetime.DateFormatter;
import sun.jvm.hotspot.debugger.ThreadContext;

import java.util.Date;
import java.util.Map;

/**
 * Created by harlenzhang on 2016/12/7.
 */
public class DateTimeTest {
    public static void main(String[] args) {
        Runnable task = new Runnable() {
            public void run() {
                Thread job = new Thread(new Runnable() {
                    public void run() {
                        try {
                            Thread.currentThread().sleep(5000);
                            System.out.println("我是定时任务，我要结束了" + Thread.currentThread().getId());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
                job.setDaemon(true);
                job.start();

                try {
                    System.out.println(Thread.currentThread().isDaemon());
                    Thread.currentThread().sleep(1500);
                    System.out.println("我是请求，我要结束了" + Thread.currentThread().getId());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        try {
            Thread testThread =  new Thread(task);
            testThread.start();
            Map<Thread, StackTraceElement[]> threadMap = Thread.getAllStackTraces();
            for (Thread thread : threadMap.keySet())
                System.out.println(thread.getId());
            Thread.currentThread().sleep(10000);
            System.out.println("我是容器");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


