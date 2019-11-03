package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    
    private Stack example_1 = new Stack();
    private int[] arguments = {1,2,3,4};
    private int[] arguments_r = {4,3,2,1};
    private Stack example_2 = new Stack();

    @Test(expected = IndexOutOfBoundsException.class)
    public void peek() {
        for (int i = 0; i < arguments.length; i++) {
            example_1.push(arguments[i]);
            assertEquals(arguments[i], example_1.peek());
        }
        example_2.peek();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void pop() {
        for (int i = 0; i < arguments.length; i++) {
            example_1.push(arguments[i]);
        }
        for (int i = 0; i < arguments.length; i++) {
            assertEquals(arguments_r[i], example_1.pop());
        }
        example_2.pop();
    }

    @Test
    public void push() {
        for (int i = 0; i < arguments.length; i++) {
            example_1.push(arguments[i]);
        }
    }
}
