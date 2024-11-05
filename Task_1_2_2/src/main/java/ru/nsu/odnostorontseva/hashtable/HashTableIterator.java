package ru.nsu.odnostorontseva.hashtable;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator to traverse all key-value pairs in a hash table.
 *
 * @param <K> (the type of keys).
 * @param <V> (the type of values).
 */
public class HashTableIterator<K, V> implements Iterator<Entry<K, V>> {
    private final HashTable<K, V> hashTable;
    private int currentId;
    private int currentEntryId;
    private final int expectedMod;


    /**
     * Constructing an iterator for the specified hash-table.
     *
     * @param hashTable (the hash-table).
     */
    HashTableIterator(HashTable<K, V> hashTable) {
        this.hashTable = hashTable;
        this.expectedMod = hashTable.modCounter;
        this.currentId = 0;
        this.currentEntryId = 0;
    }

    @Override
    public boolean hasNext() {
        while (currentId < hashTable.capacity
                && (hashTable.table[currentId] == null
                || hashTable.table[currentId].isEmpty())) {
            currentId++;
        }
        return currentId < hashTable.capacity;
    }

    @Override
    public Entry<K, V> next() {
        if (expectedMod != hashTable.modCounter) {
            throw new ConcurrentModificationException();
        }

        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        Entry<K, V> entry = hashTable.table[currentId].get(currentEntryId++);

        if (currentEntryId >= hashTable.table[currentId].size()) {
            currentEntryId = 0;
            currentId++;
        }

        return entry;
    }
}
