import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by rg029761 on 1/23/16.
 */
public class RightSideView {
    int maxLevelSoFar = -1;
    TreeNode root;

    private TreeNode createTree()
    {
        root = new TreeNode(1);
        TreeNode n1   = new TreeNode(2);
        TreeNode n2   = new TreeNode(3);
        TreeNode n3   = new TreeNode(4);
        TreeNode n4   = new TreeNode(5);
        TreeNode n5   = new TreeNode(6);
        TreeNode n6   = new TreeNode(8);
        TreeNode n7   = new TreeNode(9);
        TreeNode n8   = new TreeNode(10);

        root.left  = n1;
        root.right = n2;
        n1.left  = n3;
        n1.right = n4;
        n2.left  = n5;
        n3.right = n6;
        n5.right = n7;
        n6.right = n8;
        return root;
    }

    private void printRightView(TreeNode currentNode, int currentLevel) {
        if (currentNode == null) return;

        if (currentLevel > maxLevelSoFar)
        {
            System.out.println(currentNode.val);
            maxLevelSoFar = currentLevel;
        }

        printRightView(currentNode.right, currentLevel + 1);
        printRightView(currentNode.left, currentLevel + 1);
    }

    public static void main(String[] args)
    {
        RightSideView tree = new RightSideView();
        tree.createTree();
        tree.printRightView(tree.root, 0);

        // tree.printRightViewLevelOrder(tree.root);
    }

    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if(root == null) return result;

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(queue.size() > 0){
            //get size here
            int size = queue.size();

            for(int i=0; i<size; i++){
                TreeNode top = queue.remove();

                //the first element in the queue (right-most of the tree)
                if(i==0){
                    result.add(top.val);
                }
                //add right first
                if(top.right != null){
                    queue.add(top.right);
                }
                //add left
                if(top.left != null){
                    queue.add(top.left);
                }
            }
        }
        return result;
    }
}
