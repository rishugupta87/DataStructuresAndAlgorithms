package BST;

import binarytree.common.BinaryTreePrinter;
import org.junit.Test;

/**
 * Created by rg029761 on 8/5/15.
 */
public class DiameterTest {

    @Test
    public void testDiameter() {

        BinarySearchTree bt = new  BinarySearchTree(60);
        bt.add(30);
        bt.add(25);
        bt.add(35);
        bt.add(30);
        bt.add(40);
        bt.add(20);
        bt.add(90);
        bt.add(130);
        bt.add(120);
        bt.add(140);
        bt.add(110);
        bt.add(125);
        bt.add(105);

        BinaryTreePrinter.printNode(bt.getRoot());
        System.out.println(Diameter.findDiameter(bt.getRoot()));
    }
}
