package binarytree;

import util.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by rg029761 on 9/25/15.
 * https://www.youtube.com/watch?v=D2bIbWGgvzI
 */
public class ReverseLevelOrderTraversal {

    private static Stack<Node> treeStack = new Stack<Node>();
    private static List<Integer> list = new ArrayList<Integer>();
    int tos = -1;

    //print level order traversal in reverse
    public static List<Integer> printReverseLevelOrder(final Node root) {

        if(root == null) {
            return Collections.EMPTY_LIST;
        }

        treeStack.push(root);
        int i = 0;
        while(i != treeStack.size()) {
            Node tosNode = treeStack.get(i);
            if(tosNode.getRight() != null) {
                treeStack.push(tosNode.getRight());
            }
            if(tosNode.getLeft() != null) {
                treeStack.push(tosNode.getLeft());
            }
            i++;
        }
        while(!treeStack.isEmpty()) {
            list.add(treeStack.pop().getData());
        }
        return list;
    }

    //do level ordet traversal then reverse
    public static List<ArrayList<Integer>> levelOrderBottom(Node root) {
        ArrayList<ArrayList<Integer>> result = new  ArrayList<ArrayList<Integer>>();

        if(root == null){
            return result;
        }

        LinkedList<Node> current = new LinkedList<Node>();
        LinkedList<Node> next = new LinkedList<Node>();
        current.offer(root);

        ArrayList<Integer> numberList = new ArrayList<Integer>();

        // need to track when each level starts
        while(!current.isEmpty()){
            Node head = current.poll();

            numberList.add(head.getData());

            if(head.getLeft() != null){
                next.offer(head.getLeft());
            }
            if(head.getRight()!= null){
                next.offer(head.getRight());
            }

            if(current.isEmpty()){
                current = next;
                next = new LinkedList<Node>();
                result.add(numberList);
                numberList = new ArrayList<Integer>();
            }
        }

        //return Collections.reverse(result);
        ArrayList<ArrayList<Integer>> reversedResult = new  ArrayList<ArrayList<Integer>>();
        for(int i=result.size()-1; i>=0; i--){
            reversedResult.add(result.get(i));
        }

        return reversedResult;
    }
}
