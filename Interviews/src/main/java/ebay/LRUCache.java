package ebay;

import java.util.HashMap;
import java.util.Map;

/**
 * http://algorithmsandme.in/2014/02/least-recently-used-cache/#.VQRI_PmUfA0Created by rg029761 on 8/6/16.
 *
 * head of queue is most recently used
 * tail is least frequently used
 * add elements from right to left in queue.
 *
 1. If cache has free entry, add the page entry to tail of the queue.
 2. If cache hit, override the previous value in the cache.
 3. If cache miss and the cache is full, remove the page at front and insert the new page at head of queue.
 4. To check hit or miss, use hash table.
 */
public class LRUCache {

    int capacity;
    Map<Integer, Node> map = new HashMap<Integer, Node>();
    Node head=null;
    Node end=null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }

        return -1;
    }

    public void remove(Node n){
        if(n.pre!=null){
            n.pre.next = n.next;
        }else{
            head = n.next;
        }

        if(n.next!=null){
            n.next.pre = n.pre;
        }else{
            end = n.pre;
        }

    }

    public void setHead(Node n){
        n.next = head;
        n.pre = null;

        if(head!=null)
            head.pre = n;

        head = n;

        if(end ==null)
            end = head;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node old = map.get(key);
            old.value = value;
            //remove(old);
            //setHead(old);
        }else{
            Node created = new Node(key, value);
            if(map.size()>=capacity){
                map.remove(end.key);
                remove(end);
                setHead(created);

            }else{
                setHead(created);
            }

            map.put(key, created);
        }
    }

}

class Node{
    int key;
    int value;
    Node pre;
    Node next;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
