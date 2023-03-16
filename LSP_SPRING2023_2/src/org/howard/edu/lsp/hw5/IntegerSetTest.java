package org.howard.edu.lsp.hw5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IntegerSetTest {

    @Test
    @DisplayName("Test case for clear")
    public void testClear() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.clear();
        Assertions.assertEquals(0, set.length());
    }

    @Test
    @DisplayName("Test case for length")
    public void testLength() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(3);
        Assertions.assertEquals(3, set.length());
    }

    @Test
    @DisplayName("Test case for equals")
    public void testEquals() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(2);
        set2.add(1);

        IntegerSet set3 = new IntegerSet();
        set3.add(1);
        set3.add(2);
        set3.add(4);

        Assertions.assertTrue(set1.equals(set2));
        Assertions.assertFalse(set1.equals(set3));
    }

    @Test
    @DisplayName("Test case for contains")
    public void testContains() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(3);
        Assertions.assertTrue(set.contains(2));
        Assertions.assertFalse(set.contains(4));
    }

    @Test
    @DisplayName("Test case for largest")
    public void testLargest() throws IntegerSetException { 
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(3);
        Assertions.assertEquals(3, set.largest());
    }

    @Test
    @DisplayName("Test case for smallest")
    public void testSmallest() throws IntegerSetException {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(3);
        Assertions.assertEquals(1, set.smallest());
    }

    @Test
    @DisplayName("Test case for add")
    public void testAdd() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        Assertions.assertEquals(2, set.length());
        Assertions.assertTrue(set.contains(1));
    }

    @Test
    @DisplayName("Test case for remove")
    public void testRemove() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.remove(1);
        Assertions.assertEquals(1, set.length());
        Assertions.assertFalse(set.contains(1));
    }

    @Test
    @DisplayName("Test case for union")
    public void testUnion() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        IntegerSet result = set1.union(set2);
        IntegerSet expected = new IntegerSet();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);

        Assertions.assertTrue(result.equals(expected));
    }
    @Test
    @DisplayName("Test case for intersect")
    public void testIntersect() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        IntegerSet result = set1.intersect(set2);
        IntegerSet expected = new IntegerSet();
        expected.add(3);

        Assertions.assertTrue(result.equals(expected));
    }
    @Test
    @DisplayName("Test case for diff")
    public void testDiff() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        IntegerSet result = set1.diff(set2); 

        IntegerSet expected = new IntegerSet();
        expected.add(1);
        expected.add(2);

        Assertions.assertTrue(result.equals(expected)); 
    }

    @Test
    @DisplayName("Test case for isEmpty")
    public void testIsEmpty() {
        IntegerSet set = new IntegerSet();
        Assertions.assertTrue(set.isEmpty());

        set.add(1);
        Assertions.assertFalse(set.isEmpty());
    }

    @Test
    @DisplayName("Test case for toString")
    public void testToString() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(3);

        String expected = "{1, 2, 3}";
        Assertions.assertEquals(expected, set.toString());
    }
}