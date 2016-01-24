/**
 *
 Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

 If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

 You may not alter the values in the nodes, only nodes itself may be changed.

 Only constant memory is allowed.

 For example,
 Given this linked list: 1->2->3->4->5

 For k = 2, you should return: 2->1->4->3->5

 For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;

        while(p != null){
            int count = 0;
            ListNode curr = p.next;
            while(curr != null && count < k){
                curr = curr.next;
                count++;
            }
            if(count < k)
                break;
            else{
                //reverse nodes in k-group
                //set the temp to be the next node to the kth node
                ListNode temp = curr;
                //reset curr back to the beginning
                curr = p.next;
                //reset count to 0
                count = 0;
                //reverse the next k nodes
                while(count < k){
                    ListNode next = curr.next;
                    curr.next = temp;
                    temp = curr;
                    curr = next;
                    count++;
                }
                //reset count to 0
                count = 0;
                p.next = temp;
                //move p k nodes forward
                while(count < k){
                    p = p.next;
                    count++;
                }
            }
        }

        return dummy.next;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group:
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }
}
