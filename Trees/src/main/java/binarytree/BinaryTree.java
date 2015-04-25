package binarytree;

import util.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rg029761 on 6/10/15.
 */
public class BinaryTree<T> {

    private final Node root;
    private static final Queue<Node> queue = new LinkedList<Node>();

    public BinaryTree(final int data) {
        root = new Node(data);
    }

    public Node getRoot() {
        return root;
    }

    /**
     * left, root, right
     * @param root
     */
    public void inOrderTraversal(final Node root) {
        if(root == null) return;
        inOrderTraversal(root.getLeft());
        System.out.printf("%d,", root.getData());
        inOrderTraversal(root.getRight());
    }

    public static Node search(final Node root, final int data) {
        if(root == null) {
            return null;
        }

        if(root.getData() == data){
            return root;
        } else {
            Node foundNode = search(root.getLeft(), data);
            if(foundNode == null) {
                foundNode = search(root.getRight(), data);
            }
            return foundNode;
        }
    }

    public void add(final int data) {
        if(queue.isEmpty()) {
            queue.add(root);
        }
        Node newNode = new Node(data);
        addNode(newNode);
    }

    public int findMax(final Node root) {
        if(root == null) {
            return 0;
        }

        int maxLeft = findMax(root.getLeft());
        int maxRight = findMax(root.getRight());

        int max = Math.max(maxLeft, maxRight);

        int MAX = Math.max(max, root.getData());

        return MAX;
    }

    public static int height(final Node root) {
        if(root == null) {
            return 0;
        }
        return (1 + Math.max(height(root.getLeft()), height(root.getRight())));
    }

    private void addNode(final Node currNode) {
        if(currNode == null) return;
        if(queue.peek().getLeft() == null) {
            queue.add(currNode);
            queue.peek().setLeft(currNode);
            return;
        }

        if(queue.peek().getRight() == null) {
            queue.add(currNode);
            queue.peek().setRight(currNode);
            return;
        }
        queue.remove();
        addNode(currNode);
    }
}
