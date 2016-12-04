package thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by harlenzhang on 2016/12/3.
 */
public class ReentrantLockStudy {
    public static void main(String[] args) {
        final ReentrantLock reentrantLock = new ReentrantLock(false);
        Runnable task = new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("this is the thread :" + Thread.currentThread().getId());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                reentrantLock.lock();
                System.out.println(Thread.currentThread().getId() + "拿到锁了");
                System.out.println("现在等待队列有："+ reentrantLock.getQueueLength());
                System.out.println("我先休息3秒");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                reentrantLock.unlock();
            }
        };

        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
    }
}
