import java.util.ArrayDeque;

public class LearnDeque3 {
    public static void main(String[] args) {
        ArrayDeque<Integer> adq = new ArrayDeque<>();
        adq.offer(23);
        adq.offerFirst(12); // adds element at the beginning
        adq.offerLast(33); // adds element at the end of the deque
        adq.offer(45);

        System.out.println("Double-ended Queue: " + adq);

        System.out.println("Peak : " + adq.peek());
        System.out.println("Peak First: " + adq.peekFirst());
        System.out.println("Peak Last: " + adq.peekLast());

        System.out.println(adq.poll());
        System.out.println("After poll() : " + adq);
        System.out.println(adq.pollFirst());
        System.out.println("After pollFirst() : " + adq);
        System.out.println(adq.pollLast());
        System.out.println("After pollLast() : " + adq);
    }
}
