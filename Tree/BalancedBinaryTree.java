// Brute Force Approach

import java.util.*;
public class BalancedBinaryTree{
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }
    public static boolean isBalanced(Node root){
        if(root == null){
            return true;  // a null tree is balanced
        }
        int lh = height(root.left);
        int rh = height(root.right);
        // Check if the current node is balanced and if the left and right subtrees are balanced
        if(Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right)){
            return true;
        }
        return false;
    }
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }
    public static void main(String[] args){
        // Node root = new Node(1);
        // root.left = new Node(2);
        // root.right = new Node(3);
        // root.left.left = new Node(4);
        // root.left.right = new Node(5);
        // root.right.left = new Node(6);
        // root.right.right = new Node(7);
        // System.out.println(isBalanced(root)); -> true
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.left.left = new Node(4);
        root.left.left.left.left = new Node(5);
        root.right = new Node(6);
        System.out.println(isBalanced(root));
    }
}