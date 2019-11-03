package ua.edu.ucu.collections;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList content;

    public Queue() {
        content = new ImmutableLinkedList();
    }

    public Object peek() {
        if (content.size() == 0) {
            throw new IndexOutOfBoundsException("Queue is empty!");
        }
        return content.getFirst();
    }

    public Object dequeue() {
        if (content.size() == 0) {
            throw new IndexOutOfBoundsException("Queue is empty!");
        }
        Object result = content.getFirst();
        content = content.removeFirst();
        return result;
    }

    public void enqueue(Object e) {
        content = content.addLast(e);
    }
}
