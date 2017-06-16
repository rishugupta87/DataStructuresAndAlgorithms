package BST;


public class SortedListToBinarySearchTree {

    /**
     *
     *
     1) Get the Middle of the linked list and make it root.
     2) Recursively do same for left half and right half.
     a) Get the middle of left half and make it left child of the root
     created in step 1.
     b) Get the middle of right half and make it right child of the
     root created in step 1.
     */
    public static void sortedListToBSTTopDownApproach() {

    }

    /**
     * The method 1 constructs the tree from root to leaves. In this method, we construct from leaves to root.
     * The idea is to insert nodes in BST in the same order as the appear in Linked List, so that the tree can be constructed in O(n) time complexity.
     * We first count the number of nodes in the given Linked List. Let the count be n. After counting nodes, we take left n/2 nodes and recursively construct
     * the left subtree. After left subtree is constructed, we allocate memory for root and link the left subtree with root. Finally, we recursively construct
     * the right subtree and link it with root.
     While constructing the BST, we also keep moving the list head pointer to next so that we have the appropriate pointer in each recursive call.
     */
    public static void sortedListToBSTBottomUpApproach() {

    }

}
