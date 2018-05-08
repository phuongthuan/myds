package ds.npt.queue;

import java.util.*;

public class QueueLinkedList {

    Node front;
    Node rear;
    int size;


    public QueueLinkedList() {
        front = null;
        rear = null;
        size = 0;
    }

    /**
     * Check queue is empty or not.
     */
    public boolean isEmpty() {
        return (front == null);
    }

    /**
     * Get size of queue.
     */
    public int getSize() {
        return size;
    }

    /**
     * Enqueue an element.
     */
    public void enqueue(int x) {
        //Create a new node.
        Node temp = new Node(x);

        //If queue empty
        if (isEmpty()) {
            front = rear = temp;
            return;
        } else {
            rear.next = temp;
            rear = temp;
        }
        size++;
    }

    /**
     * Dequeue an element.
     */
    public int dequeue() {
        Node temp = front;
        if (isEmpty()) throw new NoSuchElementException("Underflow Exception");

        if (front == rear) {
            front = rear = null;
        } else {
            front = front.next;
        }
        size--;
        return temp.data;
    }


    /**
     * Get first node in queue.
     */
    public int front() {
        if (isEmpty()) throw new NoSuchElementException("Underflow Exception");
        return front.data;
    }

    /**
     * Display all data in queue.
     */
    public void print() {
        System.out.print("\nQueue = ");
        if (size == 0)
        {
            System.out.print("Empty\n");
            return;
        }
        Node ptr = front;
        while (ptr != rear.next)
        {
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }


}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        next = null;
    }
}


