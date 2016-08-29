package binarytree.crackingcodinginterview;

import unit2.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary search tree, design an algorithm which creates a linked list of all
 * the nodes at each depth (eg, if you have a tree with depth D, you’ll have D linked lists).
 */
public class BinaryTreeLinkedListDepth {

    public static List<LinkedList<LLNode>> createLinkedList(final Node root) {
        if(root == null) {
            return Collections.EMPTY_LIST;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        List<LinkedList<LLNode>> result = new ArrayList<LinkedList<LLNode>>();

        while(!queue.isEmpty()) {
            LinkedList ll = new LinkedList();
            int count = queue.size();
            while(count > 0) {
                Node n = queue.remove();
                if(n.left != null) {
                    queue.add(n.left);
                }
                if(n.right != null) {
                    queue.add(n.right);
                }
                ll.add(n.data);
                count --;
            }
            result.add(ll);
        }
        return result;
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.left = new Node(11);

        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);


        System.out.println(BinaryTreeLinkedListDepth.createLinkedList(root));
    }
}

class LLNode {
    private int data;
    private Node next;

    public LLNode(final int data) {
        this.data = data;
        this.next = null;
    }
}

