package BST;

import binarytree.common.BinaryTreePrinter;
import org.junit.Test;
import util.Node;

/**
* Created by rg029761 on 5/10/15.
*/
public class BinarySearchTreeTest {

    @Test
    public void testCreateBinaryTree() {
        BinarySearchTree bt = new  BinarySearchTree(50);
        bt.add(40);
        bt.add(30);
        bt.add(80);
        bt.add(45);
        bt.add(90);
        bt.add(70);
        bt.inOrderTraversal(bt.getRoot());
    }

    @Test
    public void testPreorderTraversal() {
        BinarySearchTree bt = new  BinarySearchTree(30);
        bt.add(20);
        bt.add(15);
        bt.add(25);
        bt.add(50);
        bt.add(45);
        bt.add(60);
        System.out.println("Preorder");
        bt.preOrderTraversal(bt.getRoot());
        System.out.println();
    }

    @Test
         public void testInorderTraversal() {

        BinarySearchTree bt = new  BinarySearchTree(30);
        bt.add(20);
        bt.add(15);
        bt.add(25);
        bt.add(50);
        bt.add(45);
        bt.add(60);
        System.out.println("Inorder");
        bt.inOrderTraversal(bt.getRoot());
        System.out.println();
    }

    @Test
    public void testInorderTraversal2() {

        BinarySearchTree bt = new  BinarySearchTree(35);
        bt.add(30);
        bt.add(25);
        bt.add(32);
        bt.add(50);
        bt.add(45);
        bt.add(55);
        bt.add(53);
        BinaryTreePrinter.printNode(bt.getRoot());
        System.out.println("Inorder");
        bt.inOrderTraversal(bt.getRoot());
        System.out.println();
    }

    @Test
    public void testPostOrderTraversal() {

        BinarySearchTree bt = new  BinarySearchTree(30);
        bt.add(20);
        bt.add(15);
        bt.add(25);
        bt.add(50);
        bt.add(45);
        bt.add(60);
        System.out.println("Postorder");
        bt.postOrderTraversal(bt.getRoot());
        System.out.println();
    }

    @Test
    public void testLevelOrderTraversal() {
        BinarySearchTree bt = new  BinarySearchTree(30);
        bt.add(20);
        bt.add(15);
        bt.add(25);
        bt.add(50);
        bt.add(45);
        bt.add(60);
        System.out.println("levelorder");
        bt.levelOrderTraversal(bt.getRoot());
        System.out.println();
    }

    @Test
    public void testLevelOrderTraversal_recurse() {
        BinarySearchTree bt = new  BinarySearchTree(30);
        bt.add(20);
        bt.add(15);
        bt.add(25);
        bt.add(50);
        bt.add(45);
        bt.add(60);
        bt.add(70);
        System.out.println("levelorder");
        bt.levelOrderTraversal_Recursive(bt.getRoot());
        System.out.println();
    }

    @Test
    public void testFindNode() {
        BinarySearchTree bt = new  BinarySearchTree(30);
        bt.add(20);
        bt.add(15);
        bt.add(25);
        bt.add(50);
        bt.add(45);
        bt.add(60);
        Node found = bt.find(bt.getRoot(), 5);
        if(found != null) {
            System.out.println(found.getData());
        } else {
            System.out.println(found);
        }
    }


    @Test
    public void testDeleteCase1() {
        BinarySearchTree bt = new  BinarySearchTree(30);
        bt.add(20);
        bt.add(15);
        bt.add(25);
        bt.add(50);
        bt.add(45);
        bt.add(44);
        bt.add(48);
        bt.add(60);
        bt.delete(48, bt.getRoot());
        bt.inOrderTraversal(bt.getRoot());
    }

    @Test
    public void testDeleteCase2() {
        BinarySearchTree bt = new  BinarySearchTree(30);
        bt.add(20);
        bt.add(15);
        bt.add(25);
        bt.add(50);
        bt.add(45);
        bt.add(44);
        bt.add(60);
        bt.add(55);
        bt.add(58);
        bt.delete(60, bt.getRoot());
        bt.inOrderTraversal(bt.getRoot());
    }

    @Test
    public void testDeleteCase3() {
        BinarySearchTree bt = new  BinarySearchTree(30);
        bt.add(20);
        bt.add(15);
        bt.add(25);
        bt.add(50);
        bt.add(45);
        bt.add(44);
        bt.add(60);
        bt.add(55);
        bt.add(58);
        bt.delete(50, bt.getRoot());
        bt.inOrderTraversal(bt.getRoot());
    }
}