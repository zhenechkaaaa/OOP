package ru.nsu.odnostorontseva.hashtable;

/**
 * Represents a key-value pair entry in the hash table.
 *
 * @param <K> (the type of keys).
 * @param <V> (the type of values).
 */
public class Entry<K, V> {
    private final K key;
    private V value;

    /**
     * Constructs an entry with the specified key and value.
     *
     * @param key   (the key for this entry).
     * @param value (the value for this entry).
     */
    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Returns the key for this entry.
     *
     * @return (the key).
     */
    public K getKey() {
        return key;
    }

    /**
     * Returns the value for this entry.
     *
     * @return (the value).
     */
    public V getValue() {
        return value;
    }

    /**
     * Sets the value for this entry.
     *
     * @param value (the new value for this entry).
     */
    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Entry<?, ?> e)) {
            return false;
        }
        return key.equals(e.key) && value.equals(e.value);
    }

    @Override
    public int hashCode() {
        return key.hashCode() + value.hashCode();
    }

    @Override
    public String toString() {
        return key + " = " + value;
    }
}
