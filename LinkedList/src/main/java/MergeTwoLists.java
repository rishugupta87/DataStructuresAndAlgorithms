import util.Node;

/**
 * Created by rg029761 on 10/20/15.
 */
public class MergeTwoLists {

    public static Node mergeLists(Node head1, Node head2) {
        if(head1 ==null) {
            return head2;
        }

        if(head2 == null) {
            return head1;
        }

        Node result = null;
        if(head1.getData() < head2.getData()) {
            result = head1;
            result.setNext(mergeLists(head1.getNext(), head2));
        } else {
            result = head2;
            result.setNext(mergeLists(head1, head2.getNext()));
        }
        return result;
    }
}
