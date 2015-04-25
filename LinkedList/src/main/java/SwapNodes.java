import util.Node;

/**
 * Created by rg029761 on 6/17/15.
 */
public class SwapNodes {

    /**
     * Swap K nodes.
     * Change only the links not the data.
     *
     * Example:
       Inputs:   1->2->3->4->5->6->7->8->NULL and k = 3
       Output:   3->2->1->6->5->4->8->7->NULL.

       Inputs:   1->2->3->4->5->6->7->8->NULL and k = 5
       Output:   5->4->3->2->1->8->7->6->NULL.
     */
    public static Node swapNodes_iterative(Node head, int k) {
        Node current = head;
        Node result = null;
        Node next;
        int count = 0;

        //this logic is same as reversing a list
        while(count < k && current != null) {
            next = current.getNext();
            current.setNext(result);
            result = current;
            current = next;
            count++;
        }
        //now both next and current are pointing to k+1 th node at this moment
        if(current != null) {
            Node temp = swapNodes_iterative(current, k);
            head.setNext(temp);
        }

        return result;
    }
}
