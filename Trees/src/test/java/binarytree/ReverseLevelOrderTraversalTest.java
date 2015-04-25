package binarytree;

import org.junit.Test;
import util.Node;

import java.util.List;

/**
 * Created by rg029761 on 9/25/15.
 */
public class ReverseLevelOrderTraversalTest {

    @Test
    public void testCreateBinaryTree() {
        BinaryTree bt = new  BinaryTree(10);
        bt.add(20);
        bt.add(30);
        bt.add(40);
        bt.add(50);
        bt.add(60);
        bt.add(70);
        System.out.println("Inorder");
        bt.inOrderTraversal(bt.getRoot());
        List list = ReverseLevelOrderTraversal.printReverseLevelOrder(bt.getRoot());
        System.out.println(list);
    }

    @Test
    public void testCreateBinaryTree2() {
        BinaryTree bt = new  BinaryTree(10);
        bt.add(20);
        bt.add(30);
        bt.add(40);
        bt.add(50);
        bt.add(60);
        bt.add(70);
        bt.add(80);
        System.out.println("Inorder");
        bt.inOrderTraversal(bt.getRoot());
        List list = ReverseLevelOrderTraversal.printReverseLevelOrder(bt.getRoot());
        System.out.println(list);
    }
}
