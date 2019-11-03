package ua.edu.ucu.collections.immutable;

public class ImmutableArrayList implements ImmutableList {
    private int size;
    private Object[] content;


    public ImmutableArrayList() {
        this.size = 0;
        this.content = new Object[size];
    }

    public ImmutableArrayList(Object[] arg) {
        this.size = arg.length;
        this.content = new Object[size];
        System.arraycopy(arg, 0, this.content, 0, arg.length);
    }

    @Override
    public ImmutableArrayList add(Object e) {
        return add(size(), e);
    }

    private void checkIndex(int index) {
    /*
        Auxiliary function for checking whether index is valid
         */
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index does not exist!");
        }
    }

    @Override
    public  ImmutableArrayList add(int index, Object e) {
        checkIndex(index);
        ImmutableArrayList result = new ImmutableArrayList();
        result.content = new Object[content.length + 1];
        System.arraycopy(content, 0, result.content, 0, index);
        result.content[index] = e;
        System.arraycopy(content, index, result.content,
                index + 1, content.length - index);
        result.size = size + 1;
        return result;
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        return addAll(size(), c);
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        checkIndex(index);
        ImmutableArrayList result = new ImmutableArrayList();
        result.size = c.length + size;
        result.content = new Object[size + c.length];

        System.arraycopy(content, 0, result.content, 0, index);
        System.arraycopy(c, 0, result.content, index, c.length);
        System.arraycopy(content, index, result.content, index + c.length,
                content.length - index);
        return result;
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        return content[index];
    }

    @Override
    public ImmutableArrayList remove(int index) {
        checkIndex(index);

        ImmutableArrayList result = new ImmutableArrayList();
        result.content = new Object[content.length - 1];
        result.size = size - 1;

        System.arraycopy(content, 0, result.content, 0, index);
        System.arraycopy(content, index + 1, result.content, index,
                content.length - index - 1);
        return result;
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        checkIndex(index);
        ImmutableArrayList result = remove(index);
        result = result.add(index, e);
        return result;
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size; i++) {
            if (content[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ImmutableArrayList clear() {
        ImmutableArrayList result = new ImmutableArrayList();
        return result;
    }

    @Override
    public boolean isEmpty() {
        boolean empty = size() == 0;
        return empty;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        System.arraycopy(content, 0, result, 0, size);
        return result;
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < size; i++) {
            result.append(" " + content[i]);
        }
        return result.toString();
    }
}