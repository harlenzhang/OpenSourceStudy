package thread;

import org.springframework.core.task.SimpleAsyncTaskExecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by harlenzhang on 16/7/22.
 */
public class SpringAsyc{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SimpleAsyncTaskExecutor executor = new SimpleAsyncTaskExecutor();
        FutureTask<String> task = new FutureTask(new Runnable() {
            public void run() {
                System.out.println("我在runable方法内");
                try {
                    Thread.currentThread().sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "这里是runable线程执行");

        Future<Integer> result = executor.submit(
                new Callable<Integer>() {
                    public Integer call() throws InterruptedException {
                        return 1;
                    }
                }
        );
        System.out.println("test");
            System.out.println(result.get());
        System.out.println("pring this line while executor return value");
        executor.submit(task).get();
        Thread.currentThread().sleep(100);

    }
}
