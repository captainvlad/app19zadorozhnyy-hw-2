package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    private Object[] sample_1 = {1, "string", 'a', null};
    private ImmutableLinkedList example_1 = new ImmutableLinkedList();
    private ImmutableLinkedList example_2 = new ImmutableLinkedList();
    private ImmutableLinkedList example_3 = new ImmutableLinkedList();

    @Test
    public void addFirst() {
        example_1 = example_1.addFirst("sample");
        example_3 = example_3.addFirst("sample");
        assertEquals(example_1.getFirst(), "sample");
        assertEquals(example_3.getFirst(), "sample");
    }

    @Test
    public void addLast() {
        example_1 = example_1.addLast("sample");
        example_3 = example_3.addLast("sample");
        assertEquals(example_3.getLast(), "sample");
        example_3 = example_3.addLast("new_sample");
        assertEquals(example_1.getLast(), "sample");
        assertEquals(example_3.getLast(), "new_sample");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getFirst() {
        example_3 = example_3.addLast("1_sample");
        example_3 = example_3.addLast("sample");
        assertEquals(example_3.getFirst(), "1_sample");
        example_2.getFirst();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getLast() {
        example_1 = example_1.addLast("sample");
        example_3 = example_3.addLast("sample");
        assertEquals(example_3.getLast(), "sample");
        example_3 = example_3.addLast("new_sample");
        assertEquals(example_1.getLast(), "sample");
        assertEquals(example_3.getLast(), "new_sample");
        example_2.getLast();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeFirst() {
        example_2 = example_2.addLast("1_sample");
        example_2 = example_2.addLast("sample");
        assertEquals(example_2.getFirst(), "1_sample");
        example_2 = example_2.removeFirst();
        assertEquals(example_2.getFirst(), "sample");
        example_2 = example_2.removeFirst();
        example_2.getFirst();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeLast() {
        example_2 = example_2.addLast("1_sample");
        example_2 = example_2.addLast("sample");
        assertEquals(example_2.getLast(), "sample");
        example_2 = example_2.removeLast();
        assertEquals(example_2.getLast(), "1_sample");
        example_2 = example_2.removeLast();
        example_2.getLast();
    }

    @Test
    public void add() {
        for (int i = 0; i < sample_1.length; i++) {
            example_1 =  example_1.add(sample_1[i]);
        }
        assertArrayEquals(example_1.toArray(), sample_1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAdd() {
        example_1 = example_1.add(0,sample_1[0]);
        assertEquals(example_1.size(), 1);
        assertArrayEquals(example_1.toArray(), new Object[]{1});
        assertEquals(example_1.size(), 1);
        example_2.add(100, 1);
        example_2.add(-100, 1);
    }

    @Test
    public void addAll() {
        example_3 = example_3.addAll(sample_1);
        assertArrayEquals(example_3.toArray(), sample_1);
        assertEquals(example_3.size(), sample_1.length);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAll() {
        example_3 = example_3.addAll(1, sample_1);
        assertArrayEquals(example_3.toArray(), sample_1);
        assertEquals(example_3.size(), sample_1.length);
        example_3.addAll(100, sample_1);
        example_3.addAll(-100, sample_1);
        example_2.addAll(100, sample_1);
        example_2.addAll(-100, sample_1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get() {
        example_3 = example_3.addAll(sample_1);
        assertEquals(sample_1[0], example_3.get(0));
        example_2.get(1);
        example_2.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void remove() {
        example_3 = example_3.addAll(sample_1);
        example_3 = example_3.remove(0);
        assertArrayEquals(example_3.toArray(), new Object[] {"string", 'a', null});
        assertEquals(3, example_3.size());
        example_2.remove(1);
        example_2.remove(-100);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void set() {
        example_3 = example_3.set(0, null);
        assertEquals(4, example_3.size());
        assertArrayEquals(example_3.toArray(), new Object[] {null, "string", 'a', null});
        example_3.set(1000, null);
        example_2.set(1, 'a');
        example_2.set(-100, "b");
    }

    @Test
    public void indexOf() {
        example_3 = example_3.addAll(sample_1);
        assertEquals(example_3.indexOf(null), 3);
        assertEquals(example_3.indexOf("unexistable"), -1);
        assertEquals(example_2.indexOf(1), -1);
    }

    @Test
    public void size() {
        example_3 = example_3.addAll(sample_1);
        assertEquals(example_1.size(), 0);
        assertEquals(example_2.size(), 0);
        assertEquals(example_3.size(), 4);
    }

    @Test
    public void clear() {
        example_3 = example_3.clear();
        assertEquals(example_3.size(), 0);
        assertEquals(example_3.isEmpty(), true);
    }

    @Test
    public void isEmpty() {
        example_3 = example_3.add(1);
        assertEquals(example_3.isEmpty(), false);
        assertEquals(example_2.isEmpty(), true);
        assertEquals(example_1.isEmpty(), true);
    }

    public void toArray() {
        example_3 = example_3.addAll(sample_1);
        assertArrayEquals(example_3.toArray(), sample_1);
    }

    @Test
    public void testToString() {
        example_3 = example_3.addAll(sample_1);
        String s = "1 string a null ";
        assertEquals(example_3.toString(), s);
    }
}
