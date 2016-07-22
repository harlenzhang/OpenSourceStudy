package security;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by harlenzhang on 16/6/30.
 */
public class Test {
    public static List<Node> getTreeNodes(final Node node) {
        List<Node> nodes = new ArrayList();
        if (!node.isLeaf()) {
            for (Node childNode : node.getChildNode()) {
                nodes.addAll(getTreeNodes(childNode));
            }
        }
        nodes.add(node);
        return nodes;
    }
    public static void main(String[] args) {
        Node top = new Node(0);
        top.setLeaf(true);


        for (Node node : getTreeNodes(top))
            System.out.println(node.getValue());
    }
}
