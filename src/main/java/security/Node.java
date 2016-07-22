package security;

import java.util.List;

/**
 * Created by harlenzhang on 16/6/30.
 */

public class Node {
    private Integer value;
    /**
     *
     */
    private List<Node> childNode;
    private boolean isLeaf;

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    public Node(Integer value){
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public List<Node> getChildNode() {
        return childNode;
    }

    public void setChildNode(List<Node> childNode) {
        this.childNode = childNode;
    }
}
