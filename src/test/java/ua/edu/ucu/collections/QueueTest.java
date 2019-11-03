package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {

    private Queue example = new Queue();
    private Queue example_2 = new Queue();
    private int arguments[] = {1,2,3,4};

    @Test(expected = IndexOutOfBoundsException.class)
    public void peek() {
        for (int i = 0; i < arguments.length; i++) {
            example.enqueue(arguments[i]);
            assertEquals(example.peek(), arguments[0]);
        }
        example_2.peek();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void dequeue() {
        for (int i = 0; i < arguments.length; i++) {
            example.enqueue(arguments[i]);
        }
        for (int i = 0; i < arguments.length; i++) {
            assertEquals(example.dequeue(), arguments[i]);
        }
        example_2.dequeue();
    }

    @Test
    public void enqueue() {
        for (int i = 0; i < arguments.length; i++) {
            example.enqueue(arguments[i]);
            assertEquals(example.dequeue(), arguments[i]);
        }
    }
}
