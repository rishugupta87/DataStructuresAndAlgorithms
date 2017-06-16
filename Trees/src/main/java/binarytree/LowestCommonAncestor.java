package binarytree;

import unit2.Node;

/**
 * Created by rg029761 on 8/12/15.
 */
public class LowestCommonAncestor {

    public static Node lowestCommonAncestor(final Node root, final Node a, final Node b) {
        if (root == null) {
            return null;
        }

        if (root.equals(a) || root.equals(b)) {
            // if at least one matched, no need to continue
            // this is the LCA for this root
            return root;
        }

        Node l = lowestCommonAncestor(root.left, a, b);
        Node r = lowestCommonAncestor(root.right, a, b);

        if (l != null && r != null) {
            return root;  // nodes are each on a seaparate branch
        }

        // either one node is on one branch,
        // or none was found in any of the branches
        return l != null ? l : r;
    }
}
