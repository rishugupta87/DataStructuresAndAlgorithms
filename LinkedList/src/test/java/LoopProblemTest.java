import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import util.Node;

/**
 * Created by rg029761 on 5/4/15.
 */
public class LoopProblemTest {

    private LinkedList list;

    @Before
    public void setUp() {
        list = new LinkedList(10);
    }

    @Test
    public void testLoop1() {
        list.appendAtTail(20);
        list.appendAtTail(30);
        list.appendAtTail(40);
        list.appendAtTail(50);
        list.appendAtTail(60);
        list.appendAtTail(70);
        Node current = list.getHead();
        Node temp = null;
        while(current.getNext() != null) {
            current = current.getNext();
            if(current.getData() == 40) {
                temp = current;
            }
        }
        current.setNext(temp);
        Assert.assertTrue(LoopProblem.isLoop(list));
    }

    @Test
    public void testLoop2() {
        list.appendAtTail(20);
        list.appendAtTail(30);
        list.appendAtTail(40);
        list.appendAtTail(50);
        list.appendAtTail(60);
        list.appendAtTail(70);
        Assert.assertFalse(LoopProblem.isLoop(list));
    }

    @Test
    public void testLoop3() {
        list.appendAtTail(20);
        list.appendAtTail(30);
        list.appendAtTail(40);
        list.appendAtTail(50);
        list.appendAtTail(60);
        Node current = list.getHead();
        Node temp = null;
        while(current.getNext() != null) {
            current = current.getNext();
            if(current.getData() == 30) {
                temp = current;
            }
        }
        current.setNext(temp);
        Assert.assertTrue(LoopProblem.isLoop(list));
    }

    @Test
    public void testLoop4_hashset() {
        list.appendAtTail(20);
        list.appendAtTail(30);
        list.appendAtTail(40);
        list.appendAtTail(50);
        list.appendAtTail(60);
        list.appendAtTail(70);
        Node current = list.getHead();
        Node temp = null;
        while(current.getNext() != null) {
            current = current.getNext();
            if(current.getData() == 40) {
                temp = current;
            }
        }
        current.setNext(temp);
        Assert.assertTrue(LoopProblem.isLoop_UsingHashSet(list));
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
