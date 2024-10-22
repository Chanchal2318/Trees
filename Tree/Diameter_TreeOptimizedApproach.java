// Optimized Approach - O(n)

import java.util.*;
public class Diameter_TreeOptimizedApproach {
    public static class Node{
        int data;
        Node right;
        Node left ;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static int diameterOfBinaryTree(Node root) {
        // Initialize the variable to
        // store the diameter of the tree
        int[] diameter = new int[1];
        diameter[0] = 0;
        // Call the height function to traverse
        // the tree and calculate diameter
        height(root, diameter);
        // Return the calculated diameter
        return diameter[0];
    }

    // Function to calculate the height of
    // the tree and update the diameter
    public static int height(Node node, int[] diameter) {
        // Base case: If the node is null,
        // return 0 indicating the
        // height of an empty tree
        if (node == null) {
            return 0;
        }

        // Recursively calculate the
        // height of left and right subtrees
        int[] lh = new int[1];
        int[] rh = new int[1];
        lh[0] = height(node.left, diameter);
        rh[0] = height(node.right, diameter);

        // Update the diameter with the maximum
        // of current diameter or sum of
        // left and right heights
        diameter[0] = Math.max(diameter[0], lh[0] + rh[0]);

        // Return the height of
        // the current node's subtree
        return 1 + Math.max(lh[0], rh[0]);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);
        System.out.println(diameterOfBinaryTree(root));
    }
}
