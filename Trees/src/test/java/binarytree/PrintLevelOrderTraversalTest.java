package binarytree;

import BST.BinarySearchTree;
import org.junit.Test;

/**
 * Created by rg029761 on 11/8/15.
 */
public class PrintLevelOrderTraversalTest {

    @Test
    public void testLevelOrderTraversal() {
        BinaryTree bt = new  BinaryTree(30);
        bt.add(20);
        bt.add(15);
        bt.add(25);
        bt.add(50);
        bt.add(45);
        bt.add(60);
        bt.add(90);
        System.out.println("levelorder");
        PrintLevelOrderTraversal.levelOrderTraversal(bt.getRoot());
        System.out.println();
    }
}
