package BST;

import util.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rg029761 on 5/10/15.
 */
public class BinarySearchTree {

    private static Queue<Node> globalQueue = new LinkedList<Node>();

    private final Node root;

    public BinarySearchTree(final int data) {
        root = new Node(data);
    }

    public Node getRoot() {
        return root;
    }

    /**
     * Creates a Binary search tree.
     *
     * @param data
     */
    public void add(final int data) {
        final Node nodeToAdd = new Node(data);
        traverse(root, nodeToAdd);
    }

    public void traverse(final Node currNode, final Node nodeToAdd) {
       if(currNode.getLeft() == null && nodeToAdd.getData() < currNode.getData()) {
           currNode.setLeft(nodeToAdd);
           return;
       } else if(currNode.getRight() == null && nodeToAdd.getData() > currNode.getData()){
           currNode.setRight(nodeToAdd);
           return;
       }
        if(nodeToAdd.getData() < currNode.getData()) {
            traverse(currNode.getLeft(), nodeToAdd);
        } else {
            traverse(currNode.getRight(), nodeToAdd);
        }
    }

    /**
     * root, left., right
     * @param root
     */
    public void preOrderTraversal(final Node root) {
        if(root == null) return;
        System.out.printf("%d,", root.getData());
        preOrderTraversal(root.getLeft());
        preOrderTraversal(root.getRight());
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

    /**
     * left, right, root
     * @param root
     */
    public void postOrderTraversal(final Node root) {
        if(root == null) return;
        postOrderTraversal(root.getLeft());
        postOrderTraversal(root.getRight());
        System.out.printf("%d,", root.getData());
    }

    public void levelOrderTraversal(final Node root) {
        if(root == null) return;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root); //discovered node

        while(!queue.isEmpty()) {
            //add the left and right child of the discovered node to the queue
            Node discovered = queue.remove(); //retrieve head of queue but do not remove it.
            if(discovered.getLeft() != null) queue.add(discovered.getLeft());
            if(discovered.getRight() != null) queue.add(discovered.getRight());
            System.out.println(discovered.getData()); //remove the head of the queue and print it
        }
    }

    public void levelOrderTraversal_Recursive(final Node root) {
        if(root == null) return;

        if(!globalQueue.contains(root)) {
            globalQueue.add(root);
        }
        if(root.getLeft() != null) globalQueue.add(root.getLeft());
        if(root.getRight() != null) globalQueue.add(root.getRight());
        System.out.println(globalQueue.remove().getData()); //remove the head of the queue and print it
        levelOrderTraversal_Recursive(globalQueue.peek());
    }

    /**
     * Deleting an element from a BST .
     *
     * Case 1 : when the element to be deleted is a root node
     * Case 2 : when the element to be deleted has only 1 child
     * Case 3 : when the element to be deleted has two children.
     *
     * @param data
     */
    public Node delete(final int data, Node root) {
        if(root == null) {
            throw new RuntimeException("bst is empty");
        }
        if(data < root.getData()) {
            return delete(data, root.getLeft());
        } else if(data > root.getData()) {
            return delete(data, root.getRight());
        } else { //if there is a match
            if(root.getLeft() == null && root.getRight() == null) { //Case 1 : when the element to be deleted is a root node
                if(root.getData() < root.getParent().getData()) {
                    root.getParent().setLeft(null);
                } else {
                    root.getParent().setRight(null);
                }
            } else if(root.getLeft() == null || root.getRight() == null) { //Case 2: when the element to be deleted has only 1 child
                if(root.getData() < root.getParent().getData()) {
                    if(root.getLeft() != null) {
                        root.getParent().setLeft(root.getLeft());
                    } else {
                        root.getParent().setLeft(root.getRight());
                    }
                } else {
                    if(root.getLeft() != null) {
                        root.getParent().setRight(root.getLeft());
                    } else {
                        root.getParent().setRight(root.getRight());
                    }
                }
            } else { //Case 3: when the element to be deleted has two children.
                //replace node to be deleted with the maximum from left subree or min from right subtree
                root.setData(findMax(root.getLeft()));
            }
        }
        return root;
    }

    public static int findMax(final Node root) {
        if(root.getRight() == null) {
            return root.getData();
        }

        return findMax(root.getRight());
    }
}
