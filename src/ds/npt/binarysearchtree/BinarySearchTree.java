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
     * Insert node to BST.
     */
    public void insert(int data) {
        root = insertRecursive(root, data);
    }

    /**
     * Delete node from BST.
     */
    public void delete(int data) {
        root = deleteNode(root, data);
    }

    /**
     * Get In-order Successor by giving data and root.
     */
    public BSTNode getSuccessor(int data) {
        return getInOrderSuccessor(root, data);
    }

    /**
     * Check is giving Binary Tree is BST.
     */
    public boolean checkIsBST() {
        return isBinarySearchTree(root);
    }

    /**
     * Find minimum data in BST.
     */
    public int findMinRec() {
        return findMinUsingRecursion(root);
    }

    public int findHeightBST() {
        return findHeight(root);
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

    /**
     * Delete a node in BST.
     */
    private BSTNode deleteNode(BSTNode root, int data) {
        if (root == null) return root;
        else if (data < root.data) deleteNode(root.left, data);
        else if (data > root.data) deleteNode(root.right, data);
        else {
            //Case 1: Node leaf (no child)
            if (root.left == null && root.right == null) { //Node leaf
                root = null;
            }
            //Case 2: One child
            else if (root.left == null) {
                BSTNode temp = root;
                root = root.right;
                temp = null;
            } else if (root.right == null) {
                BSTNode temp = root;
                root = root.left;
                temp = null;
            }
            //Case 3: Two child.
            else {
                BSTNode minRight = findMin(root.right);
                root.data = minRight.data;
                root.right = deleteNode(root.right, minRight.data);
            }
        }
        return root;
    }

    private BSTNode findMin(BSTNode root) {
        if (root == null) return null;
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    /**
     * Find in-order(LDR) successor by giving data.
     *
     * Successor is the node that would come immediately after
     * the given node in in-order traversal of the BST.
     */
    private BSTNode getInOrderSuccessor(BSTNode root, int data) {
        //Search the node O(h) - h is height of the BST.
        BSTNode cur = find(root, data);
        if (cur == null) return null;

        //Case 1: If cur node has right subtree.
        if (cur.right != null) {
            return findMin(cur.right); //Tc: O(h)
        }
        //Case 2: If cur node hasn't right subtree.
        else {
            BSTNode successor = null;
            BSTNode ancestor = root;
            while (ancestor != cur) {
                if (cur.data < ancestor.data) {
                    successor = ancestor;
                    ancestor = ancestor.left;
                } else {
                    ancestor = ancestor.right;
                }
            }
            return successor;
        }
    }

    /**
     * Find data in BST.
     */
    private BSTNode find(BSTNode root, int data) {
        if (root == null) return null;
        else if (data == root.data) return root;
        else if (data < root.data) return find(root.left, data);
        else return find(root.right, data);
    }

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
