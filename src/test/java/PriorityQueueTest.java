import by.harlap.queue.PriorityQueue;
import by.harlap.queue.impl.PriorityQueueImpl;
import org.junit.jupiter.api.Test;
import util.Kitten;
import util.KittensByAgeComparator;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriorityQueueTest {

    @Test
    public void testForReversedIntegers(){
        Comparator<Integer> reverseComparator = Comparator.reverseOrder();
        PriorityQueue<Integer> queue = new PriorityQueueImpl<>(reverseComparator);

        queue.add(10);
        queue.add(20);

        assertEquals(queue.peek(), 20);
    }
    @Test
    public void testForComparableKittens() {
        PriorityQueue<Kitten> queue = new PriorityQueueImpl<>();

        queue.add(new Kitten("D", 9));
        queue.add(new Kitten("D", 2));
        queue.add(new Kitten("B", 3));
        queue.add(new Kitten("A", 5));
        queue.add(new Kitten("C", 4));
        queue.add(new Kitten("E", 7));

        assertEquals((new Kitten("A", 5)),  queue.peek());

        assertEquals((new Kitten("A", 5)),  queue.poll());

        assertEquals((new Kitten("B", 3)),  queue.peek());

        queue.add(new Kitten("B", 2));
        assertEquals((new Kitten("B", 2)),  queue.peek());

        assertEquals((new Kitten("B", 2)),  queue.poll());

        assertEquals((new Kitten("B", 3)),  queue.peek());

        assertEquals((new Kitten("B", 3)),  queue.poll());

        assertEquals((new Kitten("C", 4)),  queue.peek());

    }

    @Test
    //Comparator that compares by age
    public void testForKittensUsingComparator() {
        KittensByAgeComparator comparator = new KittensByAgeComparator();
        PriorityQueue<Kitten> queue = new PriorityQueueImpl<>(comparator);

        queue.add(new Kitten("D", 9));
        queue.add(new Kitten("D", 2));
        queue.add(new Kitten("B", 3));
        queue.add(new Kitten("A", 5));
        queue.add(new Kitten("C", 4));
        queue.add(new Kitten("E", 7));

        assertEquals((new Kitten("D", 2)),  queue.peek());

        assertEquals((new Kitten("D", 2)),  queue.poll());

        assertEquals((new Kitten("B", 3)),  queue.peek());

        queue.add(new Kitten("Q", 1));
        assertEquals((new Kitten("Q", 1)),  queue.peek());

    }

    @Test
    public void testForIntegers() {
        PriorityQueue<Integer> priorityQueue = new PriorityQueueImpl<>();

        priorityQueue.add(7);
        priorityQueue.add(12);
        priorityQueue.add(2);
        priorityQueue.add(16);
        priorityQueue.add(103);
        priorityQueue.add(8);
        priorityQueue.add(4);

        assertEquals(2, priorityQueue.peek());
        assertEquals(2,priorityQueue.poll());
        assertEquals(4,priorityQueue.peek());
        priorityQueue.add(1);
        assertEquals(1,priorityQueue.peek());


    }

}
