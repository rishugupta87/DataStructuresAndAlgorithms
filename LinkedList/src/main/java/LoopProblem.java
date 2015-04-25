import util.Node;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rg029761 on 5/4/15.
 */
public class LoopProblem {
    /**
     * Detect if there is a loop in the LinkedList
     *
     * @param list
     * @return
     */
    public static boolean isLoop(final LinkedList list) {
        final Node head = list.getHead();
        if (head == null) {
            return false;
        }
        if(head.getNext() == null) {
            return false;
        }
        Node ptr1 = head;
        Node ptr2 = head;

        while(ptr2 != null && ptr2.getNext() != null) {
            ptr1 = ptr1.getNext(); //increase by 1
            ptr2 = ptr2.getNext().getNext(); //increase by twice the first pointer.
            if(ptr1 == ptr2) {
                return true;
            }
        }
        return false;
    }

    /**
     * Detect if there is a loop in the LinkedList
     *
     * @param list
     * @return
     */
    public static boolean isLoop_UsingHashSet(final LinkedList list) {
        final Node head = list.getHead();
        HashSet<Node> nodesVisited = new HashSet<Node>();

        if (head == null) {
            return false;
        }
        if(head.getNext() == null) {
            return false;
        }

        Node current = head;
        while(current != null) {
            if(nodesVisited.contains(current)) {
                return true;
            } else {
                nodesVisited.add(current);
            }
        }
        return false;
    }

    /**
     * Find the Beginning of the loop.
     * Once the two pointers meet. move one of the pointers to beginning of loop and move both the poointers by 1.
     * The place they meet is the beginning of the loop.
     *
     * @param list
     * @return
     */
    public static Node findBeginningOfLoop(final LinkedList list) {
        final Node head = list.getHead();
        if (head == null) {
            return null;
        }
        if(head.getNext() == null) {
            return head;
        }
        return null;
    }

    /**
     * find the length of the linked list if there is a loop.
     *
     * @param list
     * @return
     */
//    public static int findLengthOfCircularList(final LinkedList list) {
//
//    }

}
