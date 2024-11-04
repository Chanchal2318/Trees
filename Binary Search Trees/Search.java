import java.util.*;
public class Search {
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
    public static boolean Found(Node root, int data) {
        if (root == null) {
            return false;
        }
    
        while (root != null) {
            if (root.data == data) {
                return true;
            }
            root = (data < root.data) ? root.left : root.right;
        }
    
        return false;
    }    
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(10);
        System.out.println(Found(root, 10));
    }
}
