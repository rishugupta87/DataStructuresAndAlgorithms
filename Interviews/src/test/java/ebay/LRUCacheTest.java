package ebay;

import org.junit.Test;

/**
 * Created by rg029761 on 8/21/16.
 */
public class LRUCacheTest {

    @Test
    public void test1() {
        LRUCache cache = new LRUCache(4);
        cache.put(1,11);
        cache.put(1,12);
        cache.put(2,13);
        cache.put(3,14);
        cache.put(4,15);
        cache.put(5,16);
        System.out.println();
        //cache.put(5,5); //size reaches 4 here
    }

    @Test
    public void test2() {
        LRUCache cache = new LRUCache(3);
        cache.put(1,11);
        cache.put(1,12);
        cache.put(2,13);
        //cache.get(1);
        System.out.println();
        //cache.put(5,5); //size reaches 4 here
    }
}
