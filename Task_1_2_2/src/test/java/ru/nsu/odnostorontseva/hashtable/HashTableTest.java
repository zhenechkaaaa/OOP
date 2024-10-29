package ru.nsu.odnostorontseva.hashtable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void putNullKeyTest() {
        assertThrows(NullPointerException.class,
                ()->hashTable.put(null, null));
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
    void getNullKeyTest() {
        assertThrows(NullPointerException.class,
                ()->hashTable.get(null));
    }

    @Test
    void removeTest() {
        hashTable.put("apple", "apple");
        hashTable.remove("apple");

        assertEquals(0, hashTable.size);
    }

    @Test
    void removeNullKeyTest() {
        assertThrows(NullPointerException.class,
                ()->hashTable.remove(null));
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
}