package ua.edu.ucu.collections.immutable;

public class ImmutableLinkedList implements ImmutableList {
    private Node head;
    private int size;
    private Object tail;

    private static class Node {
        private Object data;
        private Node next;
    }

    public ImmutableLinkedList() {
        head = null;
        size = 0;
    }

    private void checkIndex(int index) {
    /*
        Auxiliary function for checking whether index is valid
         */
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException("Index does not exist!");
        }
    }

    private void checkEmpty() {
    /*
        Auxiliary function for checking whether collection is not empty
         */
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Empty collection!");
        }
    }

    private void insert(Object e) {
        /*
        Auxiliary function for adding objects in the LinkedList
         */
        Node node = new Node();
        node.data = e;
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
    }

    public ImmutableLinkedList addFirst(Object e) {
        return add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return add(e);
    }

    public Object getFirst() {
        checkEmpty();
        return get(0);
    }

    public Object getLast() {
        checkEmpty();
        return tail;
    }

    public ImmutableLinkedList removeFirst() {
        checkEmpty();
        return remove(0);
    }

    public ImmutableLinkedList removeLast() {
        checkEmpty();
        return remove(size() - 1);
    }

    @Override
    public ImmutableLinkedList add(Object e) {
        return add(size(), e);
    }

    @Override
    public ImmutableLinkedList add(int index, Object e) {
        checkIndex(index);
        ImmutableLinkedList result = new ImmutableLinkedList();
        Node n = head;
        for (int i = 0; i < index; i++) {
            result.insert(n.data);
            n = n.next;
        }
        result.insert(e);
        result.tail = e;
        while (n != null) {
            result.insert(n.data);
            result.tail = n.next == null ? n.data: result.tail;
            n = n.next;
        }
        result.size = size + 1;
        return result;
    }

    @Override
    public ImmutableLinkedList addAll(Object[] c) {
        return addAll(size(), c);
    }

    @Override
    public ImmutableLinkedList addAll(int index, Object[] c) {
        checkIndex(index);
        ImmutableLinkedList result = new ImmutableLinkedList();
        Node n = head;
        for (int i = 0; i < index; i++) {
            result.insert(n.data);
            result.tail = n.next == null ? n.data: result.tail;
            n = n.next;
        }
        for (int i = 0; i < c.length; i++) {
            result = result.add(c[i]);
        }
        result.tail = c[c.length - 1];
        while (n != null) {
            result.insert(n.data);
            System.out.println(n.next);
            result.tail = n.next == null ? n.data: result.tail;
            n = n.next;
        }
        result.size = size + c.length;
        return result;
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        Node a = head;
        for (int i = 0; i < index; i++) {
            a = a.next;
        }
        return a.data;
    }

    @Override
    public ImmutableLinkedList remove(int index) {
        checkIndex(index);
        ImmutableLinkedList result = new ImmutableLinkedList();
        Node a = head;
        for (int i = 0; i < this.size(); i++) {
            if (i != index) {
                result = result.add(a.data);
                result.tail = a.data;
            }
            a = a.next;
        }
        result.size = size - 1;
        return result;
    }

    @Override
    public ImmutableLinkedList set(int index, Object e) {
        checkIndex(index);
        ImmutableLinkedList result = this.remove(index);
        result = result.add(index, e);
        return result;
    }

    @Override
    public int indexOf(Object e) {
        Node n = head;
        for (int i = 0; i < size(); i++) {
            if (n.data == e) {
                return i;
            }
            n = n.next;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ImmutableLinkedList clear() {
        ImmutableLinkedList result = new ImmutableLinkedList();
        return result;
    }

    @Override
    public boolean isEmpty() {
        boolean result = size() == 0;
        return result;
    }

    @Override
    public Object[] toArray() {
        Object result[] = new Object[size()];
        Node n = head;
        for (int i = 0; i < size(); i++) {
            result[i] = n.data;
            n = n.next;
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        Node n = head;
        while (n != null) {
            result.append(n.data + " ");
            n = n.next;
        }
        return result.toString();
    }
}