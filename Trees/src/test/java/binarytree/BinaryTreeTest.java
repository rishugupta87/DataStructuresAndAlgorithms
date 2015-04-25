package binarytree;

import BST.BinarySearchTree;
import org.junit.Test;
import util.Node;

/**
 * Created by rg029761 on 6/10/15.
 */
public class BinaryTreeTest {

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
        System.out.println();
    }

    @Test
    public void testFindMax() {
        BinaryTree bt = new  BinaryTree(4);
        bt.add(5);
        bt.add(6);
        bt.add(100);
        bt.add(20);
        bt.add(620);
        bt.add(70);
        bt.add(50);
        bt.add(30);
        System.out.println("Inorder");
        bt.inOrderTraversal(bt.getRoot());
        System.out.println();
        System.out.println(bt.findMax(bt.getRoot()));
    }


    @Test
    public void testFindNode() {
        BinaryTree bt = new  BinaryTree(10);
        bt.add(20);
        bt.add(30);
        bt.add(40);
        bt.add(50);
        bt.add(60);
        bt.add(70);
        Node found = BinaryTree.search(bt.getRoot(), 60);
        System.out.println(found.getData());
    }
}
