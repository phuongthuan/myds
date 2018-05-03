package ds.npt.linkedlist;

import java.util.Scanner;

public class SinglyLinkedList {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LinkedList myList = new LinkedList();

        System.out.println("Singly LinkedList Implementation\n");
        System.out.println("================================\n");
        char ch;

        //Perform list operations:
        do {

            System.out.println("\nSingly Linked List Operations\n");
            System.out.println("1. Insert at begining");
            System.out.println("2. Insert at end");
            System.out.println("3. Insert at position");
            System.out.println("4. Delete at position");
            System.out.println("5. Check empty");
            System.out.println("6. Check size");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter number of integer you want to insert: ");
                    int quantity1 = scanner.nextInt();
                    System.out.println("Numbers: ");

                    for (int i = 0; i < quantity1; i++) {
                        int number = scanner.nextInt();
                        myList.insertAtStart(number);
                    }
                    break;
                case 2:
                    System.out.println("Enter number of integer you want to insert: ");
                    int quantity2 = scanner.nextInt();
                    System.out.println("Numbers: ");

                    for (int i = 0; i < quantity2; i++) {
                        int number = scanner.nextInt();
                        myList.insertAtEnd(number);
                    }
                    break;
                case 3:
                    System.out.println("Enter integer element to insert: ");
                    int num = scanner.nextInt();
                    System.out.println("Enter position: ");
                    int pos = scanner.nextInt();
                    if (pos < 0 || pos > myList.getSize()) {
                        System.out.println("Invalid position! \n");
                    } else {
                        myList.insertAtPosition(num, pos);
                    }
                    break;
                case 4:
                    System.out.println("Enter position number: ");
                    int delpos = scanner.nextInt();
                    if (delpos < 0 || delpos > myList.getSize()) {
                        System.out.println("Invalid position! \n");
                    } else {
                        myList.deleteAt(delpos);
                    }
                    break;
                case 5:
                    System.out.println("Empty status: " + myList.isEmpty() + "\n");
                    break;
                case 6:
                    System.out.println("Size: " + myList.getSize() + "\n");
                    break;
                default:
                    System.out.println("Wrong empty! \n ");
                    break;
            }

            /*  Display List  */
            myList.display();
            System.out.println("\nDo you want to continue (Type Y or N) \n");
            ch = scanner.next().charAt(0);

        } while (ch == 'Y' || ch == 'y');
    }
}