import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class LearnLinkedListQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(12); // add elements to the queue, returns true or false
        queue.offer(30);
        queue.offer(19);
        queue.offer(47);

        System.out.println(queue);
        System.out.println(queue.poll()); // takes out the element from the queue
        System.out.println(queue.peek()); // which element is next-in-line to get out of the queue

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(40); // first element becomes the root
        pq.offer(12); // 12 is added to the left. Since 12 is smaller than 40, they swap places
                      // because in a Min-Heap, the smallest number must be on top!
        pq.offer(24); // 24 is added to the right of 12. Since 24 is bigger than 12, it stays put.
        pq.offer(36); // 36 is added as the left child of 40. Since 36 is smaller than 40, they swap
                      // places.

        System.out.println("Priority Queue: " + pq); // min. heap implemented by default

        pq.poll();
        System.out.println(pq);
        System.out.println("Next element going to be out : " + pq.peek());

        PriorityQueue<Integer> Maxpq = new PriorityQueue<>(Comparator.reverseOrder()); // Max. heap
        Maxpq.offer(39);
        Maxpq.offer(13);
        Maxpq.offer(23);
        Maxpq.offer(37);

        System.out.println("pq with max. heap : " + Maxpq);
        System.out.println(Maxpq.poll());
        System.out.println(Maxpq.peek());

    }
}
