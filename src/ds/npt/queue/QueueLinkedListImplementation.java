package ds.npt.queue;

import java.util.*;

public class QueueLinkedListImplementation {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        QueueLinkedList queueLinkedList = new QueueLinkedList();

        /* Perform Queue Operations */
        System.out.println("Linked Queue Test\n");
        char ch;
        do
        {
            System.out.println("\nQueue Operations");
            System.out.println("1. insert");
            System.out.println("2. remove");
            System.out.println("3. peek");
            System.out.println("4. check empty");
            System.out.println("5. size");
            int choice = scan.nextInt();
            switch (choice)
            {
                case 1 :
                    System.out.println("Enter integer element to insert");
                    queueLinkedList.enqueue( scan.nextInt() );
                    break;
                case 2 :
                    try
                    {
                        System.out.println("Removed Element = "+ queueLinkedList.dequeue());
                    }
                    catch (Exception e)
                    {
                        System.out.println("Error : " + e.getMessage());
                    }
                    break;
                case 3 :
                    try
                    {
                        System.out.println("Peek Element = "+ queueLinkedList.front());
                    }
                    catch (Exception e)
                    {
                        System.out.println("Error : " + e.getMessage());
                    }
                    break;
                case 4 :
                    System.out.println("Empty status = "+ queueLinkedList.isEmpty());
                    break;

                case 5 :
                    System.out.println("Size = "+ queueLinkedList.getSize());
                    break;

                default :
                    System.out.println("Wrong Entry \n ");
                    break;
            }
            /* display queue */
            System.out.print("=======================");
            queueLinkedList.print();

            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y'|| ch == 'y');
    }
}
