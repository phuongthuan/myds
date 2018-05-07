package ds.npt.binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    /**
     * Root of BST.
     */
    private BSTNode root;

    /**
     * Constructor.
     */
    public BinarySearchTree() {
        root = null;
    }

    /**
     * Insert data to node.
     */
    public void insert(int data) {
        root = insertRecursive(root, data);
    }

    /**
     * Check is giving Binary Tree is BST.
     */
    public boolean checkIsBST() {
        return isBinarySearchTree(root);
    }

    /**
     * Recursive function to insert a new data to BST.
     */
    private BSTNode insertRecursive(BSTNode root, int data) {
        if (root == null) { //Empty tree
            root = new BSTNode(data);
            return root;
        }

        if (data <= root.data) {
            root.left = insertRecursive(root.left, data);
        } else if (data > root.data) {
            root.right = insertRecursive(root.right, data);
        }

        return root;
    }

    // DEPTH FIRST.
    //=======================================

    public void traversalByLevelOrder() {
        levelOrder(root);
    }

    public void traversalByInOrder() {
        inOrder(root);
    }

    public void traversalByPreOrder() {
        preOrder(root);
    }

    public void traversalByPostOrder() {
        postOrder(root);
    }

    //=======================================

    /**
     * Traversal of BST by in-order approach.
     * Left => Root => Right
     */
    private void inOrder(BSTNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    /**
     * Traversal of BST by pre-order approach.
     * Root => Left => Right
     */
    private void preOrder(BSTNode root) {
        if (root == null) return;
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }


    /**
     * Traversal of BST by post-order approach.
     * Left => Right => Root
     */
    private void postOrder(BSTNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }


    // LEVEL ORDER TRAVERSAL.
    //=====================================================

    private void levelOrder(BSTNode root) {
        if (root == null) {
            return;
        }
        Queue<BSTNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            BSTNode current = q.peek();
            System.out.println(current.data + " ");
            if (current.left != null) q.add(current.left);
            if (current.right != null) q.add(current.right);
            q.poll();
        }
    }
    //======================================================

    public boolean search(int data) {
        return searchRec(root, data);
    }

    private boolean searchRec(BSTNode root, int data) {
        if (root == null) {
            return false;
        } else if (data == root.data) {
            return true;
        } else if (data <= root.data) {
            return searchRec(root.left, data);
        } else {
            return searchRec(root.right, data);
        }
    }

    /**
     * Finding a min value in Tree using iterator.
     */
    public int findMinUsingInterator() {
        if (root == null) {
            System.out.println("Error: Tree is empty!");
            return -1;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }


    public int findMinRec() {
        return findMinUsingRecursion(root);
    }

    private int findMinUsingRecursion(BSTNode root) {
        if (root == null) {
            System.out.println("Erorr: Tree is empty!");
            return -1;
        } else if (root.left == null) {
            return root.data;
        }

        //Search in left subtree.
        return findMinUsingRecursion(root.left);
    }


    public int findHeightBST() {
        return findHeight(root);
    }

    private int findHeight(BSTNode root) {
        if (root == null)
            return -1;
        return max(findHeight(root.left), findHeight(root.right)) + 1;
    }

    private int max(int a, int b) {
        if (a >= b)
            return a;
        return b;
    }


    // Check If given a Binary tree is BST?
    //==========================================================
    private boolean isSubtreeLesser(BSTNode root, int value) {
        if (root ==null) return true;
        if (root.data <= value
                && isSubtreeLesser(root.left, value)
                && isSubtreeLesser(root.right, value))
            return true;
        else
            return false;
    }

    private boolean isSubtreeGreater(BSTNode root, int value) {
        if (root == null) return true;
        if (root.data > value
                && isSubtreeGreater(root.left, value)
                && isSubtreeGreater(root.right, value))
            return true;
        else
            return false;
    }

    private boolean isBinarySearchTree(BSTNode root) {
        if (root == null) return true;
        if (isSubtreeLesser(root.left, root.data)
            && isSubtreeGreater(root.right, root.data)
            && isBinarySearchTree(root.left)
            && isBinarySearchTree(root.right))
            return true;
        else
            return false;
    }
}
