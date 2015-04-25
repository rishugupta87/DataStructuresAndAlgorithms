import util.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rg029761 on 5/3/15.
 */
public class RemoveDuplicates {

    public static void removeDuplicatesWithBuffer(final LinkedList list) {
        final Node head = list.getHead();
        if(head == null) {
            return;
        }
        if(head.getNext() == null) {
            return;
        }
        Node current = head;
        Node previous = null;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        while(current != null) {
            if(!map.containsKey(current.getData())) {
                map.put(current.getData(), 1);
                previous = current;
            } else {
                previous.setNext(current.getNext());
            }
            current = current.getNext();
        }
    }

    /**
     * Remove duplicates from ll using 2 references.
     *
     * @param ll
     */
    public static void removeDuplicatesFromSortedLL(final LinkedList ll) {
        if(ll.getHead() == null) { //empty linked list
            return;
        }
        Node head = ll.getHead();
        Node prev = head;
        Node current = head.getNext();

        while(current.getNext() != null) {
            while(current.getData() == prev.getData()) {
                current = current.getNext();
            }
            prev.setNext(current);
            prev = current;
            current = current.getNext();
        }

        if(current.getData() == prev.getData()) {
            prev.setNext(null);
        }
    }

    /**
     * Remove Duplicates from sorted LinkedList using only one reference
     * Complexity: O(n)
     */
    public static void removeDuplicatesFromSortedLL2(final LinkedList ll) {

        if(ll.getHead() == null) {
            throw new RuntimeException("linked list is empty");
        }
        Node current = ll.getHead();

        while(current.getNext() != null) {
            if(current.getData() == current.getNext().getData()) {
                current.setNext(current.getNext().getNext());
            } else {
                current = current.getNext();
            }
        }
    }

    public static void removeUnsortedDuplicatesWithoutBuffer(LinkedList ll) {
    }
}
