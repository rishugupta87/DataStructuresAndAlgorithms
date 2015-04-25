package binarytree;

import unit2.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rg029761 on 10/24/15.
 */
public class LevelWithMaxSum {

    static Queue<Node> queue = new LinkedList<Node>();
    static int max = Integer.MIN_VALUE;
    public static int findMaxLevelSum(Node root) {
        queue.add(root);

        while(!queue.isEmpty()) {
            int sum = 0;
            int levelNodes = queue.size();

            while(levelNodes > 0) {
                Node n = queue.remove();
                sum+=n.data;

                if(n.left != null) {
                    queue.add(n.left);
                }
                if(n.right != null) {
                    queue.add(n.right);
                }

                levelNodes --;
            }

            if(sum > max) {
                max = sum;
            }
        }

        return max;
    }
}
