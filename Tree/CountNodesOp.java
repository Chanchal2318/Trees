import java.util.*;
public class CountNodesOp {
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
    public static int countNodes(Node root){
        if(root == null){
            return 0;
        }
        int lh = findHeightLeft(root);
        int rh = findHeightRight(root);
        if(lh == rh){
            return (1<<lh) - 1; // 2^h -1
        }
        return 1+countNodes(root.left) + countNodes(root.right);
    }
    public static int findHeightLeft(Node root){
        int height = 0;
        while(root != null){
            height++;
            root = root.left;
        }
        return height;
    }
    public static int findHeightRight(Node root){
        int height = 0;
        while(root != null){
            height++;
            root = root.right;
        }
        return height;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        System.out.println(countNodes(root));
    }
}
