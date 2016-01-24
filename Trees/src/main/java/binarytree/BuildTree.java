package binarytree;

import util.Node;

import java.util.List;
import java.util.Stack;

/**
 * Created by rg029761 on 8/8/15.
 *
 * http://javabypatel.blogspot.in/2015/08/construct-binary-tree-from-inorder-and-post-order-traversals.html
 */
public class BuildTree {

    public static Node buildTree(int[] inorder, int[] postorder) {
        int inStart = 0;
        int inEnd = inorder.length - 1;
        int postStart = 0;
        int postEnd = postorder.length - 1;

        return buildTree(inorder, inStart, inEnd, postorder, postStart, postEnd);
    }

    public static Node buildTree(int[] inorder, int inStart, int inEnd,
                              int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd)
            return null;

        //the last element in postorder is the root
        int rootValue = postorder[postEnd];
        Node root = new Node(rootValue);

        //find that element in the inorder array and note the index
        int k = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                k = i;
                break;
            }
        }

        root.setLeft(buildTree(inorder, inStart, k - 1, postorder, postStart, postStart + k - (inStart + 1)));

        // Becuase k is not the length, it it need to -(inStart+1) to get the length
        root.setRight(buildTree(inorder, k + 1, inEnd, postorder, postStart + k- inStart, postEnd - 1));

        // postStart+k-inStart = postStart+k-(inStart+1) +1

        return root;
    }
}
