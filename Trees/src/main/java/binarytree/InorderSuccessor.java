package binarytree;

import util.Node;

/**
 * Created by rg029761 on 7/12/15.
 */
public class InorderSuccessor {
    /**
     * Find inorder successor if the parent link is provided.
     *
     * @param data
     * @param root
     * @return
     */
    public static Node getInorderSuccessor_withParentLink(int data, final Node root) {
        //first search for this node in the binary tree.
        Node currNode = BinaryTree.search(root, data);

        //Case 1 : If the x has a right child then
        // its inorder successor will the left most element in the right sub tree of x.
        if(currNode.getRight() != null) {
            Node tmp = currNode.getRight();
            while (tmp.getLeft() != null) {
                tmp = tmp.getLeft();
            }
            return tmp;
        } else if(currNode.getRight() == null){ //Case 2: If the x doesnt have a right child then its inorder successor will the one of its ancestors,
                 // using parent link keep traveling up till you get the node which is the left child of its parent.
                 // Then this parent node will be the inorder successor.
            while(currNode.getParent() != null && currNode.getParent().getLeft() != currNode) {
                currNode = currNode.getParent();
            }
            return currNode.getParent();
        }

        //Case 3: if x is the right most node in the tree then its inorder successor will be NULL.
        return null;
    }
}
