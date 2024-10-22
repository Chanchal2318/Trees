import java.util.*;
public class IdenticalTree {
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
    public static boolean isIdentical(Node root1, Node root2){
        if(root1 ==null &&  root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        return ((root1.data == root2.data) && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right));
    }
    public static void main(String[] args) {
        // Root 1
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);

        // Root 2
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        System.out.println(isIdentical(root1, root2));
    }
}
