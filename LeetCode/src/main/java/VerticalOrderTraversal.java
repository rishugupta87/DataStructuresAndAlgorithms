import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Created by rg029761 on 1/23/16.
 */
public class VerticalOrderTraversal {

    public List<List<Integer>> verticalOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Map<Integer, List<Integer>> distanceToValueMap = new TreeMap<Integer, List<Integer>>();
        Map<Integer, Integer> valueToDistanceMap = new HashMap<Integer, Integer>();

        if(root == null) {
            return Collections.emptyList();
        }

        if(root.left == null && root.right == null) {
            result.add(Arrays.asList(root.val));
            return result;
        }

        int hd = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        distanceToValueMap.put(hd, new ArrayList<Integer>(Arrays.asList(root.val)));
        valueToDistanceMap.put(root.val, hd);

        while(! queue.isEmpty()) {
            TreeNode curr = queue.remove();

            int currLevel = valueToDistanceMap.get(curr.val);

            if(curr.left != null) {
                if(distanceToValueMap.containsKey(currLevel - 1)) {
                    distanceToValueMap.get(currLevel - 1).add(curr.left.val);
                } else {
                    distanceToValueMap.put(currLevel - 1, new ArrayList<Integer>(Arrays.asList(curr.left.val)));
                }
                valueToDistanceMap.put(curr.left.val, currLevel - 1);
                queue.add(curr.left);
            }

            if(curr.right != null) {
                if(distanceToValueMap.containsKey(currLevel + 1)) {
                    distanceToValueMap.get(currLevel + 1).add(curr.right.val);
                } else {
                    distanceToValueMap.put(currLevel + 1, new ArrayList<Integer>(Arrays.asList(curr.right.val)));
                }
                valueToDistanceMap.put(curr.right.val, currLevel + 1);
                queue.add(curr.right);
            }
        }


        for(Map.Entry<Integer, List<Integer>> entry : distanceToValueMap.entrySet()) {
            ImmutableList.Builder list = ImmutableList.builder();
            list.add(entry.getValue());
            result.add(list.build());
        }

        return result;
    }

    public static void main(String args[]) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(Arrays.asList(new VerticalOrderTraversal().verticalOrder(root)));
    }
}
