package util.impl;

import org.junit.Test;

/**
 * Created by rg029761 on 5/9/15.
 */
public class HashMapTest {

    @Test
    public void test_EqualObjects() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("abc", 1);
        map.put("def", 1);
        map.put("abc", 5);
        System.out.println();
    }

    @Test
    public void test_UnequalObjectsSameHashCode() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        System.out.println("abcdef".hashCode());
        System.out.println("abcdfG".hashCode());
        System.out.println("xvgggg".hashCode());
        map.put("abcdef", 1);
        map.put("abcdfg", 1);
        map.put("xvgggg", 5);
        System.out.println();
    }

    @Test
    public void test_NullKey() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("abcdef", 1);
        map.put("abcdfg", 1);
        map.put(null, 5);
        System.out.println();
    }

    @Test
    public void test_getKey() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("abcdef", 1);
        map.put("abcdfg", 11);
        map.put("xvgggg", 5);
        int val = map.get("xvgggg");
        System.out.println(val);
    }
}
