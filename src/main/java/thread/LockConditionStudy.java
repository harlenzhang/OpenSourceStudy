package thread;

import org.codehaus.groovy.runtime.powerassert.SourceText;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by harlenzhang on 2016/12/3.
 */
public class LockConditionStudy {
    public static void main(String[] args) {
        final ReentrantLock reentrantLock = new ReentrantLock();
        final Condition condition = reentrantLock.newCondition();

        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                reentrantLock.lock();
                System.out.println("我要等人" + this);
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我等到人了" + this);
                reentrantLock.unlock();
            }
        });

        thread.start();

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
            reentrantLock.lock();
                System.out.println("我拿到锁了");
                try {
                    Thread.currentThread().sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                condition.signalAll();
                System.out.println("我说我到了");
                reentrantLock.unlock();
            }
        });

        thread1.start();
    }
}
