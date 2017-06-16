package BST;

import util.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by rg029761 on 11/21/16.
 */
public class TreeTraversals {
    private static Queue<Node> globalQueue = new LinkedList<Node>();

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
     * root, left., right
     * @param root
     */
    public void preOrderTraversal_Iterative(final Node root) {
        Node top;
        if (root == null)
            return;

        Stack<Node> st = new Stack<Node>();
        st.push(root);

        /*
         * Push the root and do the same process as recursive one but in this way:
         * a) Print the node's data
         * b) Push its right child
         * c) Push its left child.
         * This is done because stack if LIFO so left child is operated first.
         */
        while (!st.empty()) {
            top = st.pop();
            System.out.print(top.getData() + " ");
            if (top.getRight() != null)
                st.push(top.getRight());
            if (top.getLeft() != null)
                st.push(top.getLeft());
        }
    }

    public void inorderItr(Node root){
        Stack<Node> stack = new Stack<Node>();
        Node node = root;
        while(true){
            if(node != null){
                stack.push(node);
                node = node.getLeft();
            }
            else{
                if(stack.isEmpty()){
                    break;
                }
                node = stack.pop();
                System.out.println(node.getData());
                node = node.getRight();
            }
        }
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
}
