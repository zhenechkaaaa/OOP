package ru.nsu.odnostorontseva.hashtable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HashTableTest {
    private HashTable<String, String> hashTable;

    @BeforeEach
    void setUp() {
        this.hashTable = new HashTable<>(16);
    }

    @Test
    void putTest() {
        hashTable.put("apple", "apple");
        hashTable.put("banana", "banana");
        hashTable.put("berry", "berry");
        hashTable.put("cherry", "cherry");
        hashTable.put("carrot", "carrot");
        hashTable.put("cucumber", "cucumber");

        assertEquals(6, hashTable.size);
    }

    @Test
    void putIntegerKeyTest() {
        HashTable<Integer, String> hashTable1 = new HashTable<>(16);
        hashTable1.put(1, "apple");
        hashTable1.put(2, "banana");
        hashTable1.put(3, "berry");

        assertEquals(3, hashTable1.size);
    }

    @Test
    void putDoubleKeyTest() {
        HashTable<Double, String> hashTable1 = new HashTable<>(16);
        hashTable1.put(1.1, "apple");
        hashTable1.put(1.2, "banana");
        hashTable1.put(1.3, "berry");

        assertEquals(3, hashTable1.size);
    }

    @Test
    void putCharKeyTest() {
        HashTable<Character, String> hashTable1 = new HashTable<>(16);
        hashTable1.put('a', "apple");
        hashTable1.put('b', "banana");
        hashTable1.put('c', "cherry");

        assertEquals(3, hashTable1.size);
    }

    @Test
    void getTest() {
        hashTable.put("apple", "apple");

        assertEquals("apple", hashTable.get("apple"));
    }

    @Test
    void getNullTest() {
        hashTable.put("apple", null);

        assertNull(hashTable.get("apple"));
    }


    @Test
    void removeTest() {
        hashTable.put("apple", "apple");
        hashTable.remove("apple");

        assertEquals(0, hashTable.size);
    }


    @Test
    void updateTest() {
        hashTable.put("apple", "apple");
        hashTable.update("apple", "banana");

        assertNotEquals("apple", hashTable.get("apple"));
        assertEquals("banana", hashTable.get("apple"));
    }

    @Test
    void containsTest() {
        hashTable.put("apple", "apple");

        assertTrue(hashTable.contains("apple"));
    }

    @Test
    void notContainsTest() {
        hashTable.put("apple", "apple");
        assertFalse(hashTable.contains("banana"));
    }

    @Test
    void sizeTest() {
        hashTable.put("apple", "apple");
        hashTable.put("banana", "banana");
        hashTable.put("berry", "berry");
        hashTable.put("cherry", "cherry");
        hashTable.put("cucumber", "cucumber");

        assertEquals(5, hashTable.size());
    }

    @Test
    void toStringTest() {
        hashTable.put("apple", "apple");
        hashTable.put("banana", "banana");
        hashTable.put("berry", "berry");
        hashTable.put("cherry", "cherry");
        hashTable.put("cucumber", "cucumber");

        String expected = """
                cucumber = cucumber;
                apple = apple;
                banana = banana;
                cherry = cherry;
                berry = berry;
                """;
        assertEquals(expected, hashTable.toString());
    }

    @Test
    void iteratorOnEmptyTableTest() {
        Iterator<Entry<String, String>> iterator = hashTable.iterator();
        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    void testIteratorOnNotEmptyTable() {
        hashTable.put("apple", "apple");
        hashTable.put("banana", "banana");
        hashTable.put("cherry", "cherry");

        Iterator<Entry<String, String>> iterator = hashTable.iterator();

        assertTrue(iterator.hasNext());
        Entry<String, String> entry1 = iterator.next();
        assertNotNull(entry1);

        assertTrue(iterator.hasNext());
        Entry<String, String> entry2 = iterator.next();
        assertNotNull(entry2);

        assertTrue(iterator.hasNext());
        Entry<String, String> entry3 = iterator.next();
        assertNotNull(entry3);

        assertFalse(iterator.hasNext());
    }

    @Test
    void testIteratorConcurrentModification() {
        hashTable.put("apple", "apple");
        hashTable.put("banana", "banana");
        hashTable.put("cherry", "cherry");

        Iterator<Entry<String, String>> iterator = hashTable.iterator();

        assertTrue(iterator.hasNext());

        hashTable.put("cherry", "cherry");

        assertThrows(ConcurrentModificationException.class, iterator::next);
    }

    @Test
    public void testIteratorAfterRemovingElements() {
        hashTable.put("apple", "apple");
        hashTable.put("banana", "banana");
        hashTable.put("cherry", "cherry");

        hashTable.remove("banana");

        Iterator<Entry<String, String>> iterator = hashTable.iterator();

        while (iterator.hasNext()) {
            Entry<String, String> entry = iterator.next();
            assertNotNull(entry);
            assertNotEquals("banana", entry.getKey());
        }
    }

    @Test
    public void testIteratorAfterUpdatingElements() {
        hashTable.put("apple", "apple");
        hashTable.put("banana", "banana");

        hashTable.update("apple", "pineapple"); // Изменяем значение

        Iterator<Entry<String, String>> iterator = hashTable.iterator();

        boolean foundOneUpdated = false;

        while (iterator.hasNext()) {
            Entry<String, String> entry = iterator.next();
            if (entry.getKey().equals("apple")) {
                foundOneUpdated = true;
                assertEquals("pineapple", entry.getValue());
            }
        }

        assertTrue(foundOneUpdated);
    }

    @Test
    void equalsTest() {
        HashTable<String, String> hashTable2 = new HashTable<>(16);
        hashTable.put("apple", "apple");
        hashTable.put("banana", "banana");

        hashTable2.put("apple", "apple");
        hashTable2.put("banana", "banana");

        assertEquals(hashTable, hashTable2);
    }

    @Test
    void notEqualsTest() {
        HashTable<String, String> hashTable2 = new HashTable<>(16);
        hashTable.put("apple", "apple");
        hashTable.put("banana", "banana");

        hashTable2.put("apple", "apple");
        hashTable2.put("cherry", "cherry");

        assertNotEquals(hashTable, hashTable2);
    }

    @Test
    void diffCapEqualsTest() {
        HashTable<String, String> diffCapacityHashTable = new HashTable<>(20);
        hashTable.put("apple", "apple");
        hashTable.put("banana", "banana");

        diffCapacityHashTable.put("apple", "apple");
        diffCapacityHashTable.put("banana", "banana");
        assertNotEquals(hashTable, diffCapacityHashTable);
    }

    @Test
    void equalsToItselfTest() {
        hashTable.put("apple", "apple");
        assertEquals(hashTable, hashTable);
    }

    @Test
    void nullEqualsTest() {
        assertNotEquals(hashTable, null);
    }

    @Test
    void diffTypeEqualsTest() {
        assertNotEquals(hashTable, "apple");
    }

    @Test
    void hashCodeTest() {
        hashTable.put("apple", "apple");
        assertEquals(hashTable.hashCode(), hashTable.hashCode());
    }

    @Test
    void rehashTest() {
        HashTable<Integer, String> hashTable1 = new HashTable<>(4);

        hashTable1.put(1, "apple");
        hashTable1.put(2, "banana");
        hashTable1.put(3, "cherry");

        assertEquals(4, hashTable1.capacity);

        hashTable1.put(4, "cucumber");

        assertEquals(8, hashTable1.capacity);

        assertEquals("cucumber", hashTable1.get(4));
        assertEquals("apple", hashTable1.get(1));
    }

    @Test
    void collisionTest() {
        hashTable.put("apple", "apple");
        hashTable.put("banana", "banana");
        hashTable.put("berry", "berry");
        hashTable.put("cherry", "cherry");
        hashTable.put("carrot", "carrot");
        hashTable.put("cucumber", "cucumber");

        assertEquals(2,
                hashTable.table[hashTable.hashFunction("banana")].size());
    }
}