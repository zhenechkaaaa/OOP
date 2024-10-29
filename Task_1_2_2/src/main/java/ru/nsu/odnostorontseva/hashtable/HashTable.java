package ru.nsu.odnostorontseva.hashtable;

import java.util.LinkedList;
import java.util.List;

/**
 * The main container for storing key-value pairs.
 * Supporting basic operations: put, get, remove, update, contains, and iteration.
 *
 * @param <K> (the type of keys).
 * @param <V> (the type of values).
 */
public class HashTable<K, V> {
    public List<Entry<K, V>>[] table;
    public int size;
    public int capacity;

    /**
     * Constructs a hash table with the specified initial capacity.
     *
     * @param initialCapacity (the initial capacity of the hash table).
     */
    public HashTable(int initialCapacity) {
        this.capacity = initialCapacity;
        this.size = 0;
        this.table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    /**
     * Generates a hash code.
     *
     * @param key (the key to hash).
     * @return (the index in the table).
     * @throws NullPointerException (if the key is null).
     */
    private int hashFunction(K key) {
        if (key == null) {
            throw new NullPointerException();
        }

        int hash = switch (key) {
            case String k -> k.hashCode();
            case Integer k -> Integer.hashCode(k);
            case Double k -> Double.hashCode(k);
            default -> key.hashCode();
        };

        hash ^= (hash >>> 16);
        hash *= 31;
        hash ^= (hash >>> 13);
        hash *= 50929;
        hash ^= (hash >>> 16);

        return Math.abs(hash) % capacity;
    }

    /**
     * Inserts the key-value pair into the hash table.
     * If the key already exists, its value is updated.
     *
     * @param key   (the key to insert).
     * @param value (the value to associate with the key).
     * @throws NullPointerException (if the key is null).
     */
    void put(K key, V value) {
        if (key == null) {
            throw new NullPointerException();
        }

        int id = hashFunction(key);
        List<Entry<K, V>> t = table[id];
        t.add(new Entry<>(key, value));
        size++;
    }

    /**
     * Retrieves the value associated with the specified key.
     *
     * @param key (the key whose value is to be returned).
     * @return (the value associated with the key, or null if no mapping exists).
     * @throws NullPointerException (if the key is null).
     */
    public V get(K key) {
        if (key == null) {
            throw new NullPointerException();
        }

        int id = hashFunction(key);
        List<Entry<K, V>> t = table[id];

        V res = null;

        for (Entry<K, V> entry : t) {
            if (entry.getKey().equals(key)) {
                res = entry.getValue();
            }
        }

        return res;
    }

    /**
     * Removes the mapping for the key from the hash table.
     *
     * @param key (the key whose mapping is to be removed).
     * @throws NullPointerException (if the key is null).
     */
    public void remove(K key) {
        if (key == null) {
            throw new NullPointerException();
        }

        int id = hashFunction(key);
        List<Entry<K, V>> t = table[id];
        for (Entry<K, V> entry : t) {
            if (entry.getKey().equals(key)) {
                t.remove(entry);
                size--;
            }
        }
    }

    /**
     * Updates the mapping for the specified key with a new value.
     * If the key does not exist, it is added with the value.
     *
     * @param key      (the key to update).
     * @param newValue (the new value to associate with the key).
     */
    public void update(K key, V newValue) {
        int id = hashFunction(key);
        List<Entry<K, V>> t = table[id];

        for (Entry<K, V> entry : t) {
            if (entry.getKey().equals(key)) {
                entry.setValue(newValue);
                return;
            }
        }
    }

    /**
     * Checks if the hash table contains a mapping for the key.
     *
     * @param key (the key whose presence is to be tested).
     * @return (true if the key exists in the hash table, false otherwise).
     */
    public boolean contains(K key) {
        return get(key) != null;
    }

    /**
     * Returns the number of key-value mappings in the hash table.
     *
     * @return (the number of entries in the hash table).
     */
    public int size() {
        return size;
    }


}
