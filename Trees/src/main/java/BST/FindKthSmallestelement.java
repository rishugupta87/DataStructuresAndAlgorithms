package BST;

import util.Node;

/**
 * Created by rg029761 on 11/26/16.
 */
public class FindKthSmallestelement {

    static int count = 0;

    // do inorder traversal
    public static Node findKthSmallest(Node root, int k) {
        if(root == null) {
            return null;
        }

        Node node = findKthSmallest(root.getLeft(), k);

        // If counter is not equal to K, then only increment the counter.
        // Once counter is equal to K, it means we have found the desired smallest element and no need to increment further,
        // Take the back up of the current node as it might be the Kth smallest element we are looking for.
        if(count != k) {
            count++;
            node = root;
        }
        //This is the place where actual check is going to happen between counter and K,
        //If counter matched K, it means we found the node and no need to find further so
        if(count == k) {
            return node;
        } else {
            return findKthSmallest(root.getRight(), k);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bt = new  BinarySearchTree(30);
        bt.add(20);
        bt.add(15);
        bt.add(25);
        bt.add(50);
        bt.add(45);
        bt.add(60);
        System.out.println(FindKthSmallestelement.findKthSmallest(bt.getRoot(), 3).getData());
    }
}
