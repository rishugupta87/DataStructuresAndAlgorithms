package binarytree;

import unit2.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by rg029761 on 8/9/15.
 */
public class BinaryTreeViews {

    static final Queue<Node> queue = new LinkedList<Node>();
    static final List<Node> rightViewNodes = new ArrayList<Node>();

    /**
     * Do Level order traversal and pick the last node in a level.
     *
     * @param root
     * @return
     */
    public static List<Node> getRightSideView(final Node root) {
        queue.add(root);

        int currentLevel = 1;
        int nextLevel = 0; //how many nodes in the nextLevel

        while(!queue.isEmpty()) {
            Node currentNode = queue.remove();
            currentLevel --;

            if(currentNode.left != null) {
                queue.add(currentNode.left);
                nextLevel++;
            }

            if(currentNode.right != null) {
                queue.add(currentNode.right);
                nextLevel++;
            }

            if(currentLevel == 0) { //when we see currLevel it is the last node in that level
                rightViewNodes.add(currentNode);
                currentLevel = nextLevel;
                nextLevel = 0;
            }
        }
        return rightViewNodes;
    }
}
