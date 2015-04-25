package concurrentcollections;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * ConcurrentHashMap in Java is introduced as an alternative of Hashtable in Java 1.5 as part of Java concurrency package.
 * Prior to Java 1.5 if you need a Map implementation, which can be safely used in a concurrent and multi-threaded Java
 * program, than, you only have Hashtable or synchronized Map because HashMap is not thread-safe. With ConcurrentHashMap,
 * now you have better choice; because, not only it can be safely used in concurrent multi-threaded environment but also
 * provides better performance over Hashtable and synchronizedMap. ConcurrentHashMap performs better than earlier two because
 * it only locks a portion of Map, instead of whole Map, which is the case with Hashtable and synchronized Map
 Read more: http://javarevisited.blogspot.com/2013/02/concurrenthashmap-in-java-example-tutorial-working.html#ixzz3qI0gK4nl

 http://javarevisited.blogspot.sg/2013/02/concurrent-collections-from-jdk-56-java-example-tutorial.html
 */
public class ConcurrentHashMapUsage {
    /**
     * What do putIfAbsent method do>
       If map does not contain specified key, put specified key-value pair in map and return null.
       If map already contains specified key, return value corresponding to specified key.

       Equuivalent to
         synchronized (map){
             if (!map.containsKey(key))
                return map.put(key, value);
             else
                return map.get(key);
            }
     * @param args
     */
    public static void main(String args[]) {

        ConcurrentMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<Integer, String>();
        concurrentHashMap.put(1, "javaMadeSoEasy");
        System.out.println("concurrentHashMap : "+concurrentHashMap);

        System.out.println("\n putIfAbsent method >>"+ concurrentHashMap.putIfAbsent(1, "ankit"));
        System.out.println("concurrentHashMap : "+concurrentHashMap);

        System.out.println("\n putIfAbsent method >> "+ concurrentHashMap.putIfAbsent(2, "audi"));
        System.out.println("concurrentHashMap : "+concurrentHashMap);

    }
}
