package binarytree;

import util.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by rg029761 on 9/25/15.
 */
public class ReverseLevelOrderTraversal {

    private static Stack<Node> treeStack = new Stack<Node>();
    private static List<Integer> list = new ArrayList<Integer>();
    int tos = -1;

    //print level order traversal in reverse
    public static List<Integer> printReverseLevelOrder(final Node root) {

        if(root == null) {
            return Collections.EMPTY_LIST;
        }

        treeStack.push(root);
        int i = 0;
        while(i != treeStack.size()) {
            Node tosNode = treeStack.get(i);
            if(tosNode.getRight() != null) {
                treeStack.push(tosNode.getRight());
            }
            if(tosNode.getLeft() != null) {
                treeStack.push(tosNode.getLeft());
            }
            i++;
        }
        while(!treeStack.isEmpty()) {
            list.add(treeStack.pop().getData());
        }
        return list;
    }
}
