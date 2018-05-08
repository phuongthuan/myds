package ds.npt.queue;

public class Queue {

    private static final int MAX_SIZE = 101;
    int Q[] = new int[MAX_SIZE];
    int front, rear;

    /*
     * Current position = i
     * Next position = (i+1)%N
     * Previous position = (i+N-1)%N
     *
     * with N is size of Array.
     */

    /**
     * Constructor - set front and rear as -1.
     * We are assuming that for an empty Queue, both front and rear will be -1.
     */
    public Queue() {
        front = -1;
        rear = -1;
    }


    /**
     * Check queue is empty or not.
     */
    public boolean isEmpty() {
        return (front == -1 && rear == -1);
    }

    /**
     * Check queue is full or not.
     */
    public boolean isFull() {
        //If the next position of rear (rear+1)%MAX_SIZE is front => queue is full.
        if ((rear+1)%MAX_SIZE == front) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Insert an element in queue.
     */
    public void enqueue(int x) {
        if (isFull()) {
            System.out.println("Error: Queue is full.\n");
            return;
        }
        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1)%MAX_SIZE;
        }
        Q[rear] = x;
    }

    /**
     * Remove an element in queue.
     */
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Error: Queue is empty.\n");
        } else if (front == rear) {
            front = rear = -1;
        } else {
          front = (front + 1)%MAX_SIZE;
        }
    }

    /**
     * Return element in front of queue and not delete.
     */
    public int front() {
        //If queue is empty
        if (front == -1) {
            System.out.println("Cannot return front from empty queue.\n");
        }
        return Q[front];
    }

    /**
     * Printing the elements in queue from front to rear.
     * This function is only to test the code.
     * This is not a standard function for Queue implementation.
     */
    public void print() {
        //Finding number of element in queue.
        int count = (rear + MAX_SIZE - front)%MAX_SIZE + 1;

        for (int i = 0; i < count; i++) {
            int index = (front + i) %MAX_SIZE; //Index of element while travesing circularly from front.
            System.out.print(Q[index]);
        }
    }
}
