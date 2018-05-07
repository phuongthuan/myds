package ds.npt.binarysearchtree;

public class BinarySearchTree {

    /**
     * Root of BST.
     */
    BSTNode root;

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
     * Display all data of tree.
     */
    public void getBinaryTreeData() {
        displayRec(root);
    }

    /**
     * Traversal of BST
     */
    private void displayRec(BSTNode root) {
        if (root != null) {
            displayRec(root.left);
            System.out.println(root.data);
            displayRec(root.right);
        }
    }

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



}
