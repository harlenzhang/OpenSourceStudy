package Generic;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by harlenzhang on 2017/1/24.
 */
public class GenericList<T> {
    private T test(T t){
        System.out.println(t);
        return t;
    }
    public static void main(String[] args) throws InterruptedException {

        GenericList list = new GenericList();
        Object t =  list.test("test");
        Lock lock = new ReentrantLock(true);
        Condition condition = lock.newCondition();
        lock.lock();
        System.out.println("this is the main thread");
        Thread.currentThread().sleep(10000);
        condition.signalAll();
        lock.unlock();
        condition.await();

        new Thread(new Runnable() {
            public void run() {

            }
        }).start();
        System.out.println(t.getClass());
        System.out.println(t instanceof String);

    }
}
