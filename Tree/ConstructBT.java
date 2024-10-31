import java.util.*;
public class ConstructBT {
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
    // HashMap to store the indices of values in the inorder array for last lookups
    public static HashMap<Integer, Integer> inorderMap;
    // Variable to keep track of the current index in the preorder array
    public static int preorderIndex;
    // Main function to construct the tree, takes inorder and preorder arrays as input
    public static Node buildTree(int [] preorder, int [] inorder){
        // Initialize the HashMap and the preorder index
        inorderMap = new HashMap<>();
        preorderIndex = 0;
        // Fill the HashMap with inorder values and their indices
        for(int i = 0;i<inorder.length;i++){
            inorderMap.put(inorder[i],i);
        }
        // Call the helper function to build the tree and return the root
        return buildTreeHelper(preorder,0, inorder.length-1);
    }
    public static Node buildTreeHelper(int [] preorder, int inorderStart, int inorderEnd ){
        // Base Case: If there are no elements to construct the tree, return null
        if(inorderStart > inorderEnd){
            return null;
        }
        // Get the current root value from the preorder array using preorderIndex
        int rootValue = preorder[preorderIndex];
        Node root = new Node(rootValue);
        preorderIndex++;
        int inorderIndex = inorderMap.get(rootValue);
        root.left = buildTreeHelper(preorder, inorderStart, inorderIndex-1);
        root.right = buildTreeHelper(preorder, inorderIndex+1, inorderEnd);
        return root;
    }
    // Function to print the tree in inorder for verification
    public static void printInorder(Node root){
        if(root != null){
            printInorder(root.left);
            System.out.print(root.data + " ");
            printInorder(root.right);
        }
    }
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        Node root = buildTree(preorder, inorder);
        printInorder(root);
    }
}
