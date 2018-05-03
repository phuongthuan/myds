package ds.npt.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        queue.offer("Nguyen");
        System.out.println(queue);

        queue.remove();
        System.out.println(queue);

    }
}
