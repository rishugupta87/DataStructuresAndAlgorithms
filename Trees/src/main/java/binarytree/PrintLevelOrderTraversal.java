package binarytree;

import util.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rg029761 on 11/8/15.
 */
public class PrintLevelOrderTraversal {

    public static void levelOrderTraversal(final Node root) {
        if(root == null) return;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root); //discovered node

        while(!queue.isEmpty()) {

            int noOfNodes = queue.size(); //no of nodes at current level

            while(noOfNodes > 0) {
                Node current = queue.remove();
                System.out.printf("%d ", current.getData());
                if(current.getLeft() != null) queue.add(current.getLeft());
                if(current.getRight() != null) queue.add(current.getRight());
                noOfNodes --;
            }
            System.out.println();
        }
    }
}
