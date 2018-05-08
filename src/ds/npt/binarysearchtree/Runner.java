package ds.npt.binarysearchtree;

public class Runner {

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();
        /* Let us create following BST
                  50
                /    \
              30      70
             /  \    /  \
           20   40  60   80
                          \
                          100
                          / \
                         90 110
           */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.insert(100);
        tree.insert(90);
        tree.insert(110);

        /**
         * Print all node in BST.
         */
        tree.traversalByInOrder();

        tree.delete(70);

        System.out.println("====");

        tree.traversalByInOrder();

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
