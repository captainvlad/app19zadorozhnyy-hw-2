package ua.edu.ucu.collections;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList content;

    public Stack(){
        content = new ImmutableLinkedList();
    }

    public Object peek(){
        if (content.size() == 0){
            throw new IndexOutOfBoundsException("Stack is empty!");
        }
        return content.getLast();
    }

    public Object pop(){
        if (content.size() == 0){
            throw new IndexOutOfBoundsException("Stack is empty!");
        }
        Object result = peek();
        content = content.removeLast();
        return result;
    }

    public void push(Object e){
        content = content.add(e);
    }
}
