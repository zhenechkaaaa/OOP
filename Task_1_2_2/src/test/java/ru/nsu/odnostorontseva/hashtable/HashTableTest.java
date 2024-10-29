package ru.nsu.odnostorontseva.hashtable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {
    private HashTable<String, String> hashTable;

    @BeforeEach
    void setUp() {
        this.hashTable = new HashTable<>(16);
    }

    @Test
    void put() {
        hashTable.put("apple", "apple");
        hashTable.put("banana", "banana");
        hashTable.put("berry", "berry");
        hashTable.put("cherry", "cherry");
        hashTable.put("carrot", "carrot");
        hashTable.put("cucumber", "cucumber");

        assertEquals("apple", hashTable.get("apple"));
        assertEquals("cherry", hashTable.get("cherry"));
        assertEquals(6, hashTable.size);
    }

    @Test
    void get() {
    }

    @Test
    void remove() {
    }

    @Test
    void update() {
    }

    @Test
    void contains() {
    }

    @Test
    void size() {
    }
}