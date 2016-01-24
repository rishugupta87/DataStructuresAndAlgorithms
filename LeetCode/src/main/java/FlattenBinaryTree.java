/**
 * Created by rg029761 on 1/16/16.
 */
public class FlattenBinaryTree {

    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }


}
