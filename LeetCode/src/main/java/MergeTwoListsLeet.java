/**
 * Created by rg029761 on 1/9/16.
 */
public class MergeTwoListsLeet {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null) {
            return l2;
        }

        if(l2 == null) {
            return l1;
        }

        //lets start with l1
        ListNode current1 = l1;
        ListNode current2 = l2;

        ListNode previous = current1.val < current2.val ? l1:l2;
        ListNode result = previous;

        while(current1 != null && current2 != null) {
            if(current1.val < current2.val) {
                if(current1 != l1) {
                    previous.next = current1;
                }
                previous = current1;
                current1 = current1.next;
            } else {
                if(current2!= l2) {
                    previous.next = current2;
                }
                previous = current2;
                current2 = current2.next;
            }
        }

        if(current1 == null) {
            previous.next = current2;
        }

        if(current2 == null) {
            previous.next = current1;
        }

        return result;
    }
}
