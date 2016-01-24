package binarytree;

import binarytree.common.BinaryTreePrinter;
import util.Node;

/**
 * Created by rg029761 on 8/26/15.
 */
public class HasPathSum {

    public static boolean hasPathSum(Node root, int sum) {
        if (root == null)
            return false;

        if (sum - root.getData() == 0 && (root.getLeft() == null && root.getRight() == null))
            return true;

        return hasPathSum(root.getLeft(), sum - root.getData())
                || hasPathSum(root.getRight(), sum - root.getData());
    }

    public static void main(String args[]) {
        Node root = new Node(5);
        root.setLeft(new Node(4));
        root.setRight(new Node(8));
        root.getLeft().setLeft(new Node(11));
        root.getLeft().getLeft().setLeft(new Node(7));
        root.getLeft().getLeft().setRight(new Node(2));
        root.getRight().setRight(new Node(4));
        root.getRight().setLeft(new Node(13));
        root.getRight().getRight().setRight(new Node(1));
        BinaryTreePrinter.printNode(root);

        System.out.println(hasPathSum(root, 22));
    }
}
