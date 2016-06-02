package zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by harlenzhang on 16/6/2.
 */
public class CreateGroup implements Watcher{
    private ZooKeeper zk;
//    private CountDownLatch connectedSinnal = new CountDownLatch(1);
    private long connectTime;
    private long activeTime;
    public void connect(String host) throws IOException, InterruptedException {
        connectTime = System.currentTimeMillis();
        System.out.println("connect zk at: " + connectTime);
        zk = new ZooKeeper(host, 5000, this);
   //     connectedSinnal.await();
    }
    public void process(WatchedEvent watchedEvent) {
        activeTime = System.currentTimeMillis();
        System.out.println("receive event at: " + activeTime);
        System.out.println("==================================");
        System.out.println("time elapse: " + (activeTime - connectTime));
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected){
            System.out.println("receive event");
            //          connectedSinnal.countDown();
        }
    }

    public void create(String groupName) throws KeeperException, InterruptedException {
        String path = "/" + groupName;
        String createdPath = zk.create(path, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println("Created " + createdPath);
    }


    public void close() throws InterruptedException {
        zk.close();
    }

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        CreateGroup createGroup = new CreateGroup();
        createGroup.connect("localhost");
        createGroup.create("harlen");
        createGroup.close();

    }
}
