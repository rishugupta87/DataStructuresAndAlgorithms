package binarytree;

import binarytree.common.BinaryTreePrinter;
import org.junit.Test;
import util.Node;

/**
 * Created by rg029761 on 7/12/15.
 */
public class InorderSuccessorTest {

    @Test
    public void testInorderSuccessor() {
        final BinaryTree bt = new BinaryTree(10);
        final Node root = bt.getRoot();
        root.setLeft(new Node(20));
        root.getLeft().setLeft(new Node(40));
        root.getLeft().setRight(new Node(50));
        root.getLeft().getRight().setLeft(new Node(60));
        root.getLeft().getRight().getLeft().setRight(new Node(70));
        root.getLeft().getRight().getLeft().getRight().setRight(new Node(80));
        root.setRight(new Node(30));
        root.getRight().setLeft(new Node(90));
        root.getRight().setRight(new Node(100));
        bt.inOrderTraversal(root);
        BinaryTreePrinter.printNode(root);

        //Node node = root.getLeft().getRight().getLeft().getRight().getRight();

        Node inorderSuccessor = InorderSuccessor.getInorderSuccessor_withParentLink(80, bt.getRoot());
        System.out.println();
        System.out.println("inorder succesor:" + inorderSuccessor.getData());
    }

}
