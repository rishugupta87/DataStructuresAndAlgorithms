package binarytree;

import util.Node;

/**
 * Created by rg029761 on 8/8/15.
 */
public class HeightOfNode {

    public static int getNodeHeight(Node root, int elem, int height){
        if(root==null) return 0;
        if(root.getData() == elem) return height;

        //check if the node is present in the left sub tree
        int level = getNodeHeight(root.getLeft(), elem, height+1);
        //System.out.println(level);
        if(level!=0) return level;

        //check if the node is present in the right sub tree
        return getNodeHeight(root.getRight(), elem, height+1);
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        BinaryTree bt = new  BinaryTree(10);
        bt.add(20);
        bt.add(30);
        bt.add(40);
        bt.add(50);
        bt.add(60);
        bt.add(70);
        bt.add(80);
        System.out.println(getNodeHeight(bt.getRoot(), 80, 0));
    }
}
