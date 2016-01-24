/**
 * Created by rg029761 on 1/16/16.
 */
public class ConstructBinaryTreeFromInorderPostorder {

    public ConstructBinaryTreeFromInorderPostorder() {
        int inOrder[] =   {20, 30, 35, 40, 45, 50, 55, 60, 70};
        int postOrder[] = {20, 35, 30, 45, 40, 55, 70, 60, 50};

        TreeNode n = constructTree(inOrder, postOrder);
        System.out.println(n);
    }


    private static TreeNode constructTree(int[] inOrder, int[] preorder) {
        return constructTreeFromInOrderAndPostOrder(inOrder, 0, inOrder.length-1, preorder, 0, preorder.length-1);
    }

    private static TreeNode constructTreeFromInOrderAndPostOrder(int[] inOrder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd) {
        if(inStart > inEnd  || postStart > postEnd){
            return null;
        }

        TreeNode node = new TreeNode(postOrder[postEnd]);

        int index=0;
        for (int i = inStart; i <= inEnd; i++) {
            if(postOrder[postEnd]==inOrder[i]){
                index = i;
                break;
            }
        }

        int numberOfNodes = index - inStart;

        node.left = constructTreeFromInOrderAndPostOrder(inOrder, inStart, index-1, postOrder, postStart, (postStart + numberOfNodes)-1);
        node.right = constructTreeFromInOrderAndPostOrder(inOrder, index+1, inEnd, postOrder, postStart + numberOfNodes, postEnd-1);

        return node;
    }
}
