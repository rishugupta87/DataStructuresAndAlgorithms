package BST;

import binarytree.BinaryTree;
import util.Node;

/**
 * Created by rg029761 on 8/5/15.
 */
public class Diameter {

    public static int findDiameter(final Node root) {

        if(root == null) {
            return 0;
        }

        final int heightLeft = BinaryTree.height(root.getLeft());
        final int heightRight = BinaryTree.height(root.getRight());

        final int leftDiameter = findDiameter(root.getLeft());
        final int rightDiameter = findDiameter(root.getRight());
        return Math.max(1 + heightLeft + heightRight, Math.max(leftDiameter, rightDiameter));
    }
}
