import util.Node;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by rg029761 on 10/22/15.
 */
public class MergeKSortedLists {

    public Node mergeKLists(List<Node> lists) {
        if(lists.size() == 0)
            return null;
        PriorityQueue<Node> queue = new PriorityQueue<Node>(11, new ListNodeComparer());
        for(Node node: lists) {
            if(node != null)
                queue.add(node);
        }
        if(queue.isEmpty())
            return null;

        Node result = queue.poll();
        if(result.getNext() != null)
            queue.add(result.getNext());

        Node cur = result;

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(node.getNext() != null) {
                queue.add(node.getNext());
                node.setNext(null);
            }
            cur.setNext(node);;
            cur = cur.getNext();
        }

        return result;
    }

    private class ListNodeComparer implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return compareTo(o1.getData(), o2.getData());
        }
    }
}
