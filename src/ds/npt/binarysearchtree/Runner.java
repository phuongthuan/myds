package ds.npt.binarysearchtree;

public class Runner {

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();
        /* Let us create following BST
                  50
               /     \
              30      70
             /  \    /  \
           20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        /**
         * Print all node in BST.
         */
        tree.traversalByPreOrder();
        System.out.println(tree.checkIsBST());
//        if (tree.search(90)) {
//            System.out.println("Found");
//        } else {
//            System.out.println("Not Found");
//        }

//        System.out.println(tree.findMinUsingInterator());
//        System.out.println(tree.findMinRec());

//        System.out.println(tree.findHeightBST());
    }
}
