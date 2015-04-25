package binarytree;

import util.Node;

/**
 * Created by rg029761 on 9/26/15.
 */
public class MirrorImage {

    //transform binary tree to its mirror image.
    public static Node transform(Node root) {
        if(root == null)
            return null;

        Node left = transform(root.getLeft());
        Node right = transform(root.getRight());

        if(left != null || right != null) {
            Node tmp = root.getLeft();
            root.setLeft(root.getRight());
            root.setRight(tmp);
        }
        return root;
    }

    public boolean isMirrorImage(Node root1, Node roo2) {

        if(root1 == null && roo2 == null) {
            return true;
        }

        if(root1.getData() != roo2.getData()) {
            return false;
        }

        if(isMirrorImage(root1.getLeft(), roo2.getRight()) && isMirrorImage(root1.getRight(), roo2.getLeft())) {
            return false;
        }

        return false;
    }
}
