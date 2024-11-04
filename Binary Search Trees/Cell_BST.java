import java.util.*;
public class Cell_BST {
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
    public static int smallestCeil(Node root, int key){
       int ceil = -1;
       while(root != null){
        if(root .data == key){
            ceil = root.data;
            return ceil;
        }
        if(key > root.data){
            root = root.right;
        }
        else{
            ceil = root.data;
            root = root.left;
        }
       }
       return ceil;
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(10);
        System.out.println(smallestCeil(root,7));
    }
}
