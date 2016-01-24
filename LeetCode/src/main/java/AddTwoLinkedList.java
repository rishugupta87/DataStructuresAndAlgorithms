import java.util.LinkedList;

/**
 * Created by rg029761 on 1/3/16.
 */
public class AddTwoLinkedList {

    /**
     * You are given two linked lists representing two non-negative numbers.
     * The digits are stored in reverse order and each of their nodes contain a single digit.
     * Add the two numbers and return it as a linked list.

     Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     Output: 7 -> 0 -> 8

     Show Company Tags
     Show Tags
     Show Similar Problems

     Test cases:
     [2,4,3]
     [5,6,5]

     [2,4,3]
     [5,6,5,3,9,3]

     [2,4,3,6,7,4]
     [5,6,5]

     //this is imp case since the result is longer than the two lists which is why we have used a previous pointer
     [2,4,3]
     [5,6,9]

     Expected Answers:
     [7,0,9]
     [7,0,9,3,9,3]
     [7,0,9,6,7,4]
     [7,0,3,1]

     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //find which one of the list is larger
        int count1 = 0;
        int count2 = 0;

        ListNode list1 = l1;
        ListNode list2 = l2;

        while(list1 != null) {
            list1 = list1.next;
            count1 ++;
        }

        while(list2 != null) {
            list2 = list2.next;
            count2++;
        }

        ListNode result = count1 >= count2 ? l1 : l2;
        ListNode current = result;
        ListNode previous = result; // just keeps track of a previous node, see java docs test case

        int carry = 0;

        while(l1 != null || l2 != null) {
            int sum = 0;

            if(l1 == null) {
                sum  = carry + l2.val;
            } else if(l2 == null){
                sum  = carry + l1.val;
            } else {
                sum = carry + l1.val + l2.val;
            }

            if(sum > 9) {
                current.val = sum % 10;
                carry = 1;
            } else {
                current.val = sum;
                carry = 0;
            }
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
            previous = current;
            current = current.next;
        }

        if(carry == 1) {
            previous.next = new ListNode(1);
        }

        return result;
    }
}
