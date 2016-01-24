import org.junit.Before;
import org.junit.Test;
import util.Node;

/**
 *
 */
public class LinkedListTest {
    private LinkedList list;

    @Before
    public void setUp() {
        list = new LinkedList(10);
    }

    @Test
    public void testAppendAtTail() {
        list.appendAtTail(20);
        list.appendAtTail(30);
        list.appendAtTail(130);
        list.appendAtTail(40);
        System.out.println("=====testAppendAtTail=====");
        printLinkedList(list.getHead());
    }

    @Test
    public void testAppendAtHead() {
        list.appendAtHead(20);
        list.appendAtHead(30);
        list.appendAtHead(130);
        list.appendAtHead(40);
        System.out.println("=====testAppendAtHead=====");
        printLinkedList(list.getHead());
    }

    @Test
    public void testAppendAtPosition() {
        list.appendAtTail(20);
        list.appendAtTail(30);
        list.appendAtTail(130);
        list.appendAtTail(40);
        list.appendAtPosition(50, 1);
        list.appendAtPosition(60, 2);
        list.appendAtPosition(100, 8);
        System.out.println("=====testAppendAtPosition=====");
        printLinkedList(list.getHead());
    }

    @Test
    public void testDeleteAtPosition() {
        list.appendAtTail(20);
        list.appendAtTail(30);
        list.appendAtTail(130);
        list.appendAtTail(40);
        list.deleteNodeAtPosition(40);
        System.out.println("=====testDeleteAtPosition=====");
        printLinkedList(list.getHead());
    }

    @Test
    public void testReverse_itr() {
        list.appendAtTail(20);
        list.appendAtTail(30);
        list.appendAtTail(130);
        list.appendAtTail(40);
        printLinkedList(list.getHead());
        Node head = LinkedList.reverseLinkedList_Iterative(list.getHead());
        printLinkedList(head);
    }

    @Test
    public void testReverse_recursive() {
        list.appendAtTail(30);
        list.appendAtTail(50);
        list.appendAtTail(80);
        list.appendAtTail(90);
        printLinkedList(list.getHead());
        Node head = LinkedList.reverseLinkedList_Recursive(list.getHead());
        printLinkedList(head);
    }

    private void printLinkedList(final Node head) {
        Node current = head;
        while (current != null) {
            System.out.printf("%s,", current.getData());
            current = current.getNext();
        }
        System.out.println();
    }
}
