package util.impl;

/**
 * Created by rg029761 on 5/7/15.
 */
public class HashMap<K, V> {
    //define an initial capacity of 16
    private static final int INITIAL_CAPACITY = 16;

    private static final double LOAD_FACTOR = 0.75;
    private int threshhold;
    private double loadFactor;

    private Entry[] bucket ;

    /**
     * Applies a supplemental hash function to a given hashCode, which
     * defends against poor quality hash functions.  This is critical
     * because HashMap uses power-of-two length hash tables, that
     * otherwise encounter collisions for hashCodes that do not differ
     * in lower bits. Note: Null keys always map to hash 0, thus index 0.
     */
    static int hash(int h) {
        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    /**
     * Returns index for hash code h.
     */
    static int indexFor(int h, int length) {
        return h & (length-1);
    }

    public HashMap() {
        loadFactor = LOAD_FACTOR;
        bucket  = new Entry[INITIAL_CAPACITY];
        threshhold = (int) (INITIAL_CAPACITY * LOAD_FACTOR);
    }

    /**
     * Adding a key value to a hash map.
     *
     * @param key
     * @param value
     */
    public void put(final K key, final V value) {
        if(key == null) { //then the hash code is 0 and index is 0.
            //do something
            if(bucket[0] == null) { //allows one one null key . already null key exists do nothing.
                bucket[0] = new Entry(key, value, 0); //hashmap allows one null key
            }
            return;
        }
        final int hashCode = hash(key.hashCode() % INITIAL_CAPACITY);
        final int index = indexFor(hashCode, INITIAL_CAPACITY);
        final Entry<K, V> existingEntry = bucket[index];

        if(existingEntry != null) { //you are trying to write the key to the same bucket location.
            //if there is an existing entity.
            //check if there is an existing key, if yes override that.
            if(key.equals(existingEntry.getKey())) {
                existingEntry.setValue(value);
            } else {  //Else remember that in a bucket objects are stored in the form of a LinkedList.
                //Add the new object at the head of the linked list.
                Entry<K, V> newEntry = new Entry<K, V>(key, value, key.hashCode());
                newEntry.setNext(existingEntry);
                bucket[index] = newEntry;
            }
        } else {
            //key.hashCode()
            bucket[index] = new Entry(key, value, key.hashCode());
        }
    }

    /**
     * Getting a value from a HashMap
     */
    public V get(final K key) {
        final int hashCode = hash(key.hashCode() % INITIAL_CAPACITY);
        final int index = indexFor(hashCode, INITIAL_CAPACITY);

        final Entry<K, V> existingEntry = bucket[index];
        Entry<K, V> temp = existingEntry;
        while(temp.getNext() != null) {
            if(temp.getKey().equals(key)) {
                return temp.getVal();
            }
            temp = temp.getNext();
        }
        return temp.getVal();
    }

    /**
     * TUser defined simple Entry data structure
     * with key and value.
     * This is also used as linked list in case multiple
     * key-value pairs lead to the same bucket with same
     * hashcodes and different keys (collisions) using
     * pointer 'next'.
     *
     * @param <K>
     * @param <V>
     */
    class Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> next;
        private int hash;

        public Entry(K key, V value, int hash) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = null;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public void setNext(Entry<K, V> next) {
            this.next = next;
        }

        public Entry<K, V> getNext() {
            return this.next;
        }

        public V getVal() {
            return this.value;
        }
    }

}
