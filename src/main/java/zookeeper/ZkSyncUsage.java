package zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by harlenzhang on 16/6/2.
 */
public class ZkSyncUsage implements Watcher{
    private static CountDownLatch semaphore = new CountDownLatch(1);
    private static ZooKeeper zk = null;

    public static void main(String[] args) throws KeeperException, InterruptedException, IOException {
        String path = "/harlen";
        zk = new ZooKeeper("localhost:2181", 5000, new ZkSyncUsage());
        System.out.println("create zookeeper");
        semaphore.await();
        zk.create(path, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println("create znode");
        zk.create(path+"/child1", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println("create child node");

        List<String> childrenList = zk.getChildren(path, true);
        System.out.println(childrenList);
        zk.create(path+"/child2", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println("create child node");


    }
    public void process(WatchedEvent event) {
        if (Event.KeeperState.SyncConnected == event.getState()){
            if (Event.EventType.None == event.getType() && null == event.getPath()){
                System.out.println("event type is none");
                semaphore.countDown();
            }else if (event.getType() == Event.EventType.NodeChildrenChanged){
                try {
                    System.out.println("trigger child event" + zk.getChildren(event.getPath(), true));
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
