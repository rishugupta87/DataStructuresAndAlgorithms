import org.junit.Test;
import util.Node;

/**
 * Created by rg029761 on 5/3/15.
 */
public class RemoveDuplicatesTest {
    @Test
    public void testRemoveDuplicatesWithBuffer() {
        LinkedList ll = new LinkedList(10);
        ll.appendAtTail(20);
        ll.appendAtTail(10);
        ll.appendAtTail(50);
        ll.appendAtTail(20);
        ll.appendAtTail(20);
        ll.appendAtTail(10);
        ll.appendAtTail(60);
        ll.appendAtTail(60);
        printLinkedList(ll.getHead());
        RemoveDuplicates.removeDuplicatesWithBuffer(ll);
        printLinkedList(ll.getHead());
    }

    @Test
    public void testRemoveDuplicatesFromSortedLL() {
        LinkedList ll = new LinkedList(10);
        ll.appendAtTail(10);
        ll.appendAtTail(10);
        ll.appendAtTail(20);
        ll.appendAtTail(20);
        ll.appendAtTail(30);
        ll.appendAtTail(30);
        ll.appendAtTail(30);
        ll.appendAtTail(30);
        ll.appendAtTail(50);
        ll.appendAtTail(60);
        printLinkedList(ll.getHead());
        RemoveDuplicates.removeDuplicatesFromSortedLL(ll);
        printLinkedList(ll.getHead());
    }

    @Test
    public void testRemoveDuplicatesFromUnsortedSortedLL() {
        LinkedList ll = new LinkedList(30);
        ll.appendAtTail(20);
        ll.appendAtTail(20);
        ll.appendAtTail(30);
        ll.appendAtTail(10);
        ll.appendAtTail(50);
        ll.appendAtTail(10);
        ll.appendAtTail(10);
        ll.appendAtTail(20);
        ll.appendAtTail(50);
        ll.appendAtTail(50);
        ll.appendAtTail(100);
        printLinkedList(ll.getHead());
        RemoveDuplicates.removeUnsortedDuplicatesWithoutBuffer(ll);
        printLinkedList(ll.getHead());
    }

    private void printLinkedList(final Node ll) {
        Node current = ll;
        while (current != null) {
            System.out.printf("%s,", current.getData());
            current = current.getNext();
        }
        System.out.println();
    }
}
