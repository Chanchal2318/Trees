import java.util.*;
public class ChildrenSumProperty {
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
    public static void changeTree(Node root){
        if(root == null){
            return;
        }
        int child = 0;
        if(root.left != null){
            child = child + root.left.data;
        }
        if(root.right != null){
            child = child + root.right.data;
        }
        if(child >= root.data){
            root.data = child;
        }
        else{
            if(root.left != null){
                root.left.data = root.data;
            }
            else if(root.right != null){
                root.right.data = root.data;
            }
        }
        changeTree(root.left);
        changeTree(root.right);
        int total = 0;
        if(root.left != null){
            total = total + root.left.data;
        }
        if(root.right != null){
            total = total + root.right.data;
        }
        if(root.left != null || root.right != null){
            root.data = total;
        }
    }
    public static void inorderTraversal(Node root){
        if(root == null){
            return;
        }
        inorderTraversal(root.left);
        System.out.println(root.data + " ");
        inorderTraversal(root.right);
    }
    public static void main(String[] args){
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.right.left = new Node(0);
        root.right.right = new Node(8);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);
        System.out.println( changeTree(root));;
    }
}
