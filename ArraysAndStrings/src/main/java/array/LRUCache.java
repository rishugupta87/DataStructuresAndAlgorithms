package array;

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

    int capacity, count;
    Node head, tail;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        head.pre = null;
        tail.next = null;
        count = 0;
    }

    public void deleteNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void addToHead(Node node) {
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    public int get(int key) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            int result = node.value;
            deleteNode(node);
            addToHead(node);
            return result;
        }
        return -1;
    }

    public void set(int key, int value) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            if (count < capacity) {
                count++;
                addToHead(node);
            } else {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
                addToHead(node);
            }
        }
    }
}
class Node {
    int key;
    int value;
    Node pre;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}


