package BST;

import unit2.Node;

/**
 * Created by rg029761 on 8/11/15.
 */
public class LowestCommonAncestorBST {

    public static Node findLowestCommonAncestor(final Node root, final Node n1, final Node n2) {
        if(root == null) {
            return null;
        }

        if(root.data > n1.data && root.data > n2.data) { //n1 and n2 in left subtree
            return findLowestCommonAncestor(root.left, n1, n2);
        } else if(root.data <= n1.data && root.data < n2.data) { //n1 and n2 in right subtree
            return findLowestCommonAncestor(root.right, n1, n2);
        }
        return root; //else one node is in the left and the other in the right. root itself is the lca as its the point of divergence
    }
}
