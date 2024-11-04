import java.util.*;
public class Minimum_BST {
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
    public static int minimum(Node root){
        if(root == null){
            System.out.println("Empty BST");
            return -1;
        }
        while(root.left != null){
            root = root.left;
        }
        return root.data;
    }
    public static int maximum(Node root){
        if(root == null){
            System.out.println("Empty BST");
            return -1;
        }
        while(root.right != null){
            root = root.right;
        }
        return root.data;
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(10);
        System.out.println(minimum(root));
        System.out.println(maximum(root));
    }
}
