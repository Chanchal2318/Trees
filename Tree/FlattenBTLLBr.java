import java.util.*;
public class FlattenBTLLBr {
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
    // Initialize a global variable 'prev' to keep track of the previously processed node.
    public static Node prev = null;
    // Function to flatten a BT to a right next Linked List structure
    public static void flatten(Node root){
        // Base case: If the current node is null, return
        if(root == null){
            return;
        }
        // Recursive call to flatten the right subtree
        flatten(root.right);
        // Recursive call to flatten the left subtree
        flatten(root.left);
        // At this point, both left and right subtrees are flattened, and 'prev' is pointing to the rightmost node in the flattened right subtree.
        // Set the right child of  the current node to 'prev'.
        root.right = prev;
        // Set the left child of the current node to null
        root.left = null;
        // Update 'prev' to the current node for the next iteration.
        prev = root;
    }
    public static void printPreorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data +" ");
        printPreorder(root.left);
        printPreorder(root.right);
    }
    public static void printFlattenTree(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
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
