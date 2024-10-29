import java.util.*;
public class CountNodes{
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
    public static void inorder(Node root, int[] count){
        if(root == null){
            return ;
        }
        count[0]++;
        inorder(root.left,count);
        inorder(root.right , count);
    }
    public static int CountNodes(Node root){
        if(root == null){
            return 0;
        }
        int count[] = {0};
        inorder(root,count);
        return count[0];
    }
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        System.out.println(CountNodes(root));
    }
}