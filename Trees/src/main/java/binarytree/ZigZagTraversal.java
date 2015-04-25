package binarytree;

import util.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by rg029761 on 9/26/15.
 */
public class ZigZagTraversal {

    Queue queue = new LinkedList();

    public static void traverseZigZag(Node root) {

        Stack<Node> currLevel = new Stack();
        Stack<Node> nextLevel = new Stack();

        boolean isRightToLeft = true;

        currLevel.push(root);

        while(!currLevel.isEmpty()) {
            Node node = currLevel.pop();
            System.out.println(node.getData());

            if(isRightToLeft) {
                if(node.getLeft() != null) {
                    nextLevel.push(node.getLeft());
                }
                if(node.getRight() != null) {
                    nextLevel.push(node.getRight());
                }
            } else {
                if(node.getRight() != null) {
                    nextLevel.push(node.getRight());
                }
                if(node.getLeft() != null) {
                    nextLevel.push(node.getLeft());
                }
            }

            if(currLevel.isEmpty()) {
                currLevel = nextLevel;
                isRightToLeft = false;
            }
        }
    }
}
