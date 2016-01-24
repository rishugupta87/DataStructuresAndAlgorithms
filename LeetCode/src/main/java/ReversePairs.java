/**
 * Created by rg029761 on 1/10/16.
 */
public class ReversePairs {

    public ListNode swapPairs(ListNode head) {
        if(head == null) {
            return null;
        }

        if(head.next == null) {
            return head;
        }

        ListNode current = head;
        head = current.next;
        ListNode result = current;

        while(current != null && current.next != null) {

            result = current.next.next;
            current.next.next = current;

            if(result != null && result.next != null) {
                current.next = result.next;
            } else {
                current.next = result;
            }
            current = result;
        }

        return head;
    }
}
