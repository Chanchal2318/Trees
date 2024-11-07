import java.util.*;
public class ValidateBST {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static boolean isValidBST(Node root){
        return isValidBST(root,Long.MIN_VALUE, Long.MAX_VALUE );
    }
    public static boolean isValidBST(Node root, long minVal, long maxVal){
        if(root == null){
            return true;
        }
        if(root.data >= maxVal || root.data <= minVal){
            return false;
        }
        return isValidBST(root.left, minVal,root.data) && isValidBST(root.right,root.data,maxVal);
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(10);
        System.out.println(isValidBST(root));
    }
}
