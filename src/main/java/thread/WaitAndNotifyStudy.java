package thread;

/**
 * Created by harlenzhang on 2016/12/4.
 */
public class WaitAndNotifyStudy {

    private static final Object lock = new Object();
    private static boolean flag = true;


    public static void waiter() throws InterruptedException {
        synchronized (lock){
            System.out.println("I'm in the lock code area" + Thread.currentThread().getId());
            while (flag)
            lock.wait();
            System.out.println("I'm notified" + Thread.currentThread().getId());
        }
    }
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            public void run() {
                try {
                    waiter();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                try {
                    waiter();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                synchronized (lock){
                    System.out.println("I'm the notifier, I'm notifying main thread " + Thread.currentThread().getId());
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    flag = false;
                    lock.notifyAll();
                }
            }
        }).start();

    }
}
