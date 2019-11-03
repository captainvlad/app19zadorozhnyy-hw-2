package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {

    private Object[] sample_1 = {1, "string", 'a', null};
    private ImmutableArrayList example_1 = new ImmutableArrayList();
    private ImmutableArrayList example_2 = new ImmutableArrayList();
    private ImmutableArrayList example_3 = new ImmutableArrayList(sample_1);

    @Test
    public void add() {
        for (int i = 0; i < sample_1.length; i++) {
            example_1 =  example_1.add(sample_1[i]);
        }
        assertArrayEquals(example_1.toArray(), sample_1);
        assertArrayEquals(example_3.toArray(), sample_1);
        assertArrayEquals(example_1.toArray(), example_3.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAdd() {
        example_1 = example_1.add(1,sample_1[0]);
        assertEquals(example_1.size(), 4);
        assertArrayEquals(example_1.toArray(), new Object[]{1, 1, "string", 'a', null});
        assertEquals(example_1.size(), 5);
        example_2.add(100, 1);
    }

    @Test
    public void addAll() {
        example_3 = example_3.addAll(sample_1);
        assertArrayEquals(example_3.toArray(), new Object[]{1, "string", 'a', null, 1, "string", 'a', null});
        assertEquals(example_3.size(), 8);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAll() {
        example_3 = example_3.addAll(1, sample_1);
        assertArrayEquals(example_3.toArray(), new Object[]{1, 1, "string", 'a', null, "string", 'a', null});
        example_3 = example_3.addAll(sample_1);
        assertEquals(example_3.size(), 12);
        example_3.addAll(100, sample_1);
        example_3.addAll(-100, sample_1);
        example_2.addAll(100, sample_1);
        example_2.addAll(-100, sample_1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get() {
        example_3 = example_3.add(sample_1);
        for (int i = 0; i < sample_1.length; i++) {
            assertEquals(sample_1[i], example_3.get(i));
        }
        example_2.get(1);
        example_2.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void remove() {
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
        assertEquals(example_3.indexOf(null), 3);
        assertEquals(example_3.indexOf("unexistable"), -1);
        assertEquals(example_2.indexOf(1), -1);
    }

    @Test
    public void size() {
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
        assertEquals(example_3.isEmpty(), false);
        assertEquals(example_2.isEmpty(), true);
        assertEquals(example_1.isEmpty(), true);
    }

    @Test
    public void toArray() {
        assertArrayEquals(example_3.toArray(), sample_1);
    }

    @Test
    public void testToString() {
        String s = " 1 string a null";
        assertEquals(example_3.toString(), s);
    }
}
