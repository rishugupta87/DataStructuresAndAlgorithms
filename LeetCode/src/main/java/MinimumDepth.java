import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rg029761 on 1/23/16.
 */
public class MinimumDepth {

    public static int min = Integer.MAX_VALUE;

    public int minDepth(TreeNode root, int count) {

        if(root == null) {
            return 0;
        }

        if(root.left == null && root.right == null) {
            if(count < min) {
                min = count;
            }
            return 0;
        }

        minDepth(root.left, ++count);
        --count;
        minDepth(root.right, ++count);

        return min;
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int L = minDepth(root.left);
        int R = minDepth(root.right);
        return 1 + (Math.min(L, R) > 0 ? Math.min(L, R) : Math.max(L, R));
    }

    /**
     * level-order traversal and record current level depth, when meet a node which both child is null then return, no need to go farther
     * @param root
     * @return
     */
    public int minDepth_iterative(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int depth = 1;
        while (!queue.isEmpty()){
            int size = queue.size(); // determine the loop size
            for (int i = 0; i< size; i++){
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null){
                    return depth;
                }
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            depth ++;
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.left.left = new TreeNode(50);
        root.left.left.right = new TreeNode(70);
        root.left.left.left.left = new TreeNode(60);
        root.right.left = new TreeNode(80);
        root.right.right = new TreeNode(32);
        root.right.left.right = new TreeNode(90);

        new MinimumDepth().minDepth(root, 0);
    }
}
