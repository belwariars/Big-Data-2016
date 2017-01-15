import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.Watcher;
public class Master implements org.apache.zookeeper.Watcher {
ZooKeeper zk;
String hostPort;
Master(String hostPort) {
this.hostPort = hostPort;
}
void startZK() {
zk = new ZooKeeper(hostPort, 15000, this);
}
public void process(WatchedEvent e) {
System.out.println(e);
}
public static void main(String args[])
throws Exception {
Master m = new Master(args[0]);
m.startZK();
// wait for a bit
Thread.sleep(60000);
}
}
