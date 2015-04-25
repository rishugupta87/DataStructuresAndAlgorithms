package binarytree;

import binarytree.common.BinaryTreePrinter;
import org.junit.Test;

/**
 * Created by rg029761 on 9/26/15.
 */
public class MirrorImageTest {

    @Test
    public void testCreateBinaryTree() {
        BinaryTree bt = new  BinaryTree(10);
        bt.add(20);
        bt.add(30);
        bt.add(40);
        bt.add(50);
        bt.add(60);
        BinaryTreePrinter.printNode(bt.getRoot());
        MirrorImage.transform(bt.getRoot());
        BinaryTreePrinter.printNode(bt.getRoot());
    }
}
