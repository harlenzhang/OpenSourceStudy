package thread;

/**
 * Created by harlenzhang on 2016/12/4.
 */
public class SyncStudy {

    private static void test(){
        System.out.println("this is my room" + Thread.currentThread().getId());
    }

    public static void main(String[] args) {
       Runnable task = new Runnable() {
           public void run() {
               System.out.println("hello, all");
               synchronized (SyncStudy.class){
                   try {
                       Thread.sleep(5000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   test();
               }
           }
       };

        new Thread(task).start();
        new Thread(task).start();
    }
}
