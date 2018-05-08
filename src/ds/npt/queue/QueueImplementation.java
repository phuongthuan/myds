package ds.npt.queue;

public class QueueImplementation {

    public static void main(String[] args) {


        /*
         * Driver Code to test the implementation
         * Printing the elements in Queue after each Enqueue or Dequeue
         */

        Queue queue = new Queue(); // creating an instance of Queue.

        queue.enqueue(2);
        queue.enqueue(4);
        queue.enqueue(6);
        queue.enqueue(8);
        queue.enqueue(7);
        queue.enqueue(9);
        queue.print();

        System.out.println("\n=======");

        System.out.println("Get element: " + queue.front());
        queue.dequeue();

        queue.print();
    }
}
