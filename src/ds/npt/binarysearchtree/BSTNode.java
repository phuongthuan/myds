package ds.npt.binarysearchtree;

public class BSTNode {

    /**
     * Field of BSTNode.
     */
    int data;
    BSTNode left;
    BSTNode right;

    /**
     * Constructor.
     */
    public BSTNode(int value) {
        data = value;
        left = right = null;
    }
}
