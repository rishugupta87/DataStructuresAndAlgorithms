/**
 * Created by rg029761 on 1/16/16.
 */
public class ValidateBST {

    public boolean isValidBST(TreeNode root) {
        return isValidBST2(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    public boolean isValidBST2(TreeNode p, double min, double max){
        if(p==null)
            return true;

        if(p.val <= min || p.val >= max)
            return false;

        return isValidBST2(p.left, min, p.val) && isValidBST2(p.right, p.val, max);
    }
}
