import org.junit.Before;
import org.junit.Test;
import util.Node;

/**
 * Created by rg029761 on 6/17/15.
 */
public class SwapNodesTest {

    private LinkedList list;

    @Before
    public void setUp() {
        list = new LinkedList(1);
    }

    @Test
    public void testSwap() {
        list.appendAtTail(2);
        list.appendAtTail(3);
        list.appendAtTail(4);
        list.appendAtTail(5);
        list.appendAtTail(6);
        list.appendAtTail(7);
        list.appendAtTail(8);
        list.appendAtTail(9);
        System.out.println("=====original list=====");
        printLinkedList(list.getHead());
        Node head = SwapNodes.swapNodes_iterative(list.getHead(), 3);
        System.out.println("=====list after swap=====");
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
