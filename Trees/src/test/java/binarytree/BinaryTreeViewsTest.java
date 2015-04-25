package binarytree;

import binarytree.common.BinaryTreePrinter;
import org.junit.Test;
import unit2.Node;

import java.util.List;

/**
 * Created by rg029761 on 8/9/15.
 */
public class BinaryTreeViewsTest {

    @Test
    public void testRightSide1() {
        Node root = new Node(1);
        root.right = new Node(2);
        List<Node> nodes = BinaryTreeViews.getRightSideView(root);
        for(Node node : nodes) {
            System.out.println(node.data);
        }
    }

    @Test
    public void testRightSide2() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);

        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.right.left = new Node(9);
        root.left.left.left.left = new Node(10);
        root.left.left.left.left.right = new Node(11);

        List<Node> nodes = BinaryTreeViews.getRightSideView(root);
        for(Node node : nodes) {
            System.out.println(node.data);
        }
    }
}
