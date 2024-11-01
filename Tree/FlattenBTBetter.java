import java.util.*;

import javax.swing.tree.TreeNode;
public class FlattenBTBetter {
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
    public static Node prev = null;
    public static void flatten(Node root){
        if(root == null){
            return;
        }
        Stack<Node> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            Node curr = st.pop();
            if(curr.right != null){
                st.push(curr.right);
            }
            if(curr.left != null){
                st.push(curr.left);
            }
            if(!st.isEmpty()){
                curr.right = st.peek();
            }
            curr.left = null;
        }
    }
    public static void printPreorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }
    public static void printFlattenTree(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        printFlattenTree(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.right.right = new Node(7);
        root.right.left = new Node(8);
        System.out.print("Binary Tree Preorder: ");
        printPreorder(root);
        System.out.println();
        flatten(root);
        System.out.print("Binary Tree After Flatten: ");
        printFlattenTree(root);
        System.out.println();
    }
}
