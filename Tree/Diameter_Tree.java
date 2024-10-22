// Brute Force Approach - O(n)
import java.util.*;
public class Diameter_Tree{
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
    public static int diameterBT(Node root){
        int diameter = height(root);
        return diameter;
    }
    public static int height(Node root){
        int diameter = 0;
        if(root == null){
            return 0;
        }
        int lh= height(root.left);
        int rh = height(root.right);
        diameter = Math.max(diameter, lh+rh);
        return 1+Math.max(lh,rh);
    }
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);
        System.out.println(diameterBT(root));
    }
}