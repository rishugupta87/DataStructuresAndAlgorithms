package util.impl;

/**
 * Created by rg029761 on 8/6/16.
 */
public class HashMap2<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    private Entry[] bucket ;

    public HashMap2() {
        bucket = new Entry[INITIAL_CAPACITY];
    }


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

    public V get(K key) {
        int index = hash(key.hashCode() % INITIAL_CAPACITY);

        Entry<K, V> currEntry = bucket[index];
        while(!key.equals(currEntry.getKey())) {
            currEntry = currEntry.next;
        }
        return currEntry.getValue();
    }

    public void put(K key, V value) {

        //generate hashCode for key
        int index = hash(key.hashCode() % INITIAL_CAPACITY);

        //now go to that bucket index and check if the key already is present
        //if the key is already present,override the key
        //else add a new entry in the list in the bucket
        Entry<K, V> currEntry = bucket[index];

        if(currEntry == null) {
            bucket[index] = new Entry(key, value);
        } else {
            while(currEntry != null && currEntry.next != null) {
                if(currEntry.getKey().equals(key)) { //override
                    currEntry.value = value;
                    break;
                } else {
                    currEntry = currEntry.next;
                }
            }

            if(currEntry.next == null) {
                if(key.equals(currEntry.getKey())) {
                    currEntry.value = value;
                } else {
                    currEntry.next = new Entry(key, value);
                }
            }
        }
    }


    class Entry<K, V> {
        K key;
        V value;
        Entry next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
    }

    public static void main(String args[]) {

        HashMap2 hashMap2 = new HashMap2();
        hashMap2.put(1, 10);
        hashMap2.put(2, 11);
        hashMap2.put(3, 12);
        hashMap2.put(1, 33);

        System.out.println(hashMap2.get(2));
    }
}
