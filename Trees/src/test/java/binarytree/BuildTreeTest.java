package binarytree;

import binarytree.common.BinaryTreePrinter;
import org.junit.Test;
import util.Node;

/**
 * Created by rg029761 on 8/8/15.
 */
public class BuildTreeTest {

    @Test
    public void test() {
        int[] inorder = {4,2,5,1,6,7,3,8};
        int[] postOrder = {4,5,2,6,7,8,3,1};
        Node root = BuildTree.buildTree(inorder, postOrder);
        BinaryTreePrinter.printNode(root);
    }

}
