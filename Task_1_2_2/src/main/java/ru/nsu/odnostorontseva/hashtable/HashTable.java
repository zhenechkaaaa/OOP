package ru.nsu.odnostorontseva.hashtable;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/**
 * The main container for storing key-value pairs.
 * Supporting basic operations: put, get, remove, update, contains, and iteration.
 *
 * @param <K> (the type of keys).
 * @param <V> (the type of values).
 */
public class HashTable<K, V> implements Iterable<Entry<K, V>> {
    public List<Entry<K, V>>[] table;
    public int size;
    public int capacity;
    public int modCounter;
    private final double loadFactor;

    /**
     * Constructs a hash table with the specified initial capacity.
     *
     * @param initialCapacity (the initial capacity of the hash table).
     */
    public HashTable(int initialCapacity) {
        this.capacity = initialCapacity;
        this.size = 0;
        this.modCounter = 0;
        this.loadFactor = 0.75;
        this.table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = null;
        }
    }

    /**
     * Generates a hash code.
     *
     * @param key (the key to hash).
     * @return (the index in the table).
     * @throws NullPointerException (if the key is null).
     */
    public int hashFunction(@NotNull K key) {
        int hash = key.hashCode();

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
    void put(@NotNull K key, V value) {
        if (size >= capacity * loadFactor) {
            rehash();
        }

        int id = hashFunction(key);
        if (table[id] == null) {
            table[id] = new LinkedList<>();
        }

        List<Entry<K, V>> t = table[id];

        t.add(new Entry<>(key, value));
        size++;
        modCounter++;
    }

    /**
     * Retrieves the value associated with the specified key.
     *
     * @param key (the key whose value is to be returned).
     * @return (the value associated with the key, or null if no mapping exists).
     * @throws NullPointerException (if the key is null).
     */
    public V get(@NotNull K key) {
        V res = null;

        int id = hashFunction(key);
        if (table[id] == null) {
            return res;
        }

        List<Entry<K, V>> t = table[id];

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
    public void remove(@NotNull K key) {
        int id = hashFunction(key);
        List<Entry<K, V>> t = table[id];
        if (t == null) {
            return;
        }
        for (Entry<K, V> entry : t) {
            if (entry.getKey().equals(key)) {
                t.remove(entry);
                size--;
                modCounter++;
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
    public void update(@NotNull K key, V newValue) {
        int id = hashFunction(key);
        if (table[id] == null) {
            return;
        }
        List<Entry<K, V>> t = table[id];

        for (Entry<K, V> entry : t) {
            if (entry.getKey().equals(key)) {
                entry.setValue(newValue);
                modCounter++;
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

    /**
     * Increase capacity of hashTable.
     */
    private void rehash() {
        final List<Entry<K, V>>[] old = table;
        table = new LinkedList[(capacity *= 2)];
        for (int i = 0; i < capacity; i++) {
            table[i] = null;
        }
        size = 0;

        for (List<Entry<K, V>> t : old) {
            if (t == null) {
                continue;
            }
            for (Entry<K, V> entry : t) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override
    public @NotNull Iterator<Entry<K, V>> iterator() {
        return new HashTableIterator<>(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof HashTable<?, ?> h)) {
            return false;
        }

        return this.size == h.size
                && this.capacity == h.capacity
                && Arrays.equals(this.table, h.table);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(this.table);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < capacity; i++) {
            if (table[i] == null) {
                continue;
            }
            for (Entry<K, V> entry : table[i]) {
                sb.append(entry.toString()).append(";").append("\n");
            }
        }
        return sb.toString();
    }
}

