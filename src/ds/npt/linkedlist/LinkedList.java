package ds.npt.linkedlist;


public class LinkedList {

    public Node head;
    public int size;

    /**
     * Constructor
     */
    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Check if LinkedList is empty.
     */
    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    /**
     * Get size of list.
     */
    public int getSize() {
        return size;
    }

    /**
     * Insert data at the start of LinkedList.
     */
    public void insertAtStart(int value) {
        Node node = new Node();
        node.data = value;
        node.next = null;

        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    /**
     * Insert data at the end of LinkedList
     */
    public void insertAtEnd(int value) {
        Node node = new Node();
        node.data = value;
        node.next = null;

        if (head == null) {
            head = node;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
        size++;
    }

    /**
     * Insert data at the specified position.
     */
    public void insertAtPosition(int value, int pos) {
        Node node = new Node();
        node.data = value;
        node.next = null;

        if (pos == 0) {
            insertAtStart(value);
        } else {
            //Traverse:
            Node n = head;
            for (int i = 0; i < pos - 1; i++) {
                n = n.next;
            }
            node.next = n.next;
            n.next = node;
        }
        size++;
    }

    /**
     * Delete value at position.
     */
    public void deleteAt(int pos) {
        if (pos == 0) {
            head = head.next;
        } else {
            //Traverse:
            Node n = head;
            Node temp = null;

            for (int i = 0; i < pos - 1; i++) {
                n = n.next;
            }
            temp = n.next;
            n.next = temp.next;
            System.out.println("Node: " + temp.data + " has been deleted!");
            temp = null;
        }
    }


    public void display() {

        System.out.println("\nSingly Linked List: ");
        if (size == 0) {
            System.out.println("\nSingly Linked List empty!");
            return;
        }
        if (head.next == null) {
            System.out.println(head.data);
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print(temp.data + "\n");
    }

}



