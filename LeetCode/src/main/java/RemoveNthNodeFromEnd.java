/**
 * Created by rg029761 on 1/9/16.
 */
public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {


        if(head == null) {
            return null;
        }

        //take two pointers one pointing to head, another move n spaces ahead
        ListNode current1 = head;

        ListNode current2 = head;

        int count = 0 ;
        while(count < n) {
            current2 = current2.next;
            count++;
        }

        if(current2 == null) { //head is to be deleted
            head = head.next;
            return head;
        }

        while(current2.next != null) {
            current1 = current1.next;
            current2 = current2.next;
        }

        current1.next = current1.next.next;

        return head;
    }
}
