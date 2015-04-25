package binarytree;

import unit2.Node;

/**
 * Created by rg029761 on 8/9/15.
 */
public class SymmetricTree {

    public boolean isSymmetric(Node root) {
        if(root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(final Node l, final Node r) {
        if(l == null && r == null) {
            return true;
        } else if(l == null || r == null) {
            return false;
        }

        if(l.data != r.data) {
            return false;
        }

        if(isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left)) {
            return true;
        }

        return false;
    }
}
