import java.util.*;
public class ConstructBT2 {
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
    // Index to keep track of the current root in the postorder array
    public static int postIndex;
    // HashMap to store the index of each value in the inorder array for O(1) look-up
    public static  HashMap<Integer, Integer> inorderIndexMap;

    public static Node buildTree(int [] inorder, int[] postorder){
        // Initialize the postIndex to the last element in postorder array 
        postIndex = postorder.length -1;
        // Fill the HashMap with inorder elements and their indices
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
             inorderIndexMap.put(inorder[i], i);
        }
        // Construct the binary tree from the inorder and postorder arrays
        return constructTree(postorder, 0, inorder.length - 1);
    }
    // Helper function to construct the binary tree recursively
    public static Node constructTree(int[] postorder,int inStart, int inEnd){
        // Base condition: if there are no elements to construct the subtree
        if (inStart > inEnd) {
            return null;
        }

        // Retrieve the current root value from postorder array using postIndex
        int rootVal = postorder[postIndex--];
        // Create the root node with the current root value
        Node root = new Node(rootVal);
        // Retrieve the index of root value in inorder array using HashMap
        int inIndex = inorderIndexMap.get(rootVal);

        // Construct right subtree first (since postorder processes left -> right -> root)
        root.right = constructTree(postorder, inIndex + 1, inEnd);
        // Construct left subtree
        root.left = constructTree(postorder, inStart, inIndex - 1);
  
        return root;
    }
   // Function to print the tree in inorder to verify correctness
   public static void printInorder(Node root) {
        if (root == null) {
            return;
        }
        printInorder(root.left);
        System.out.print(root.data+ " ");  
        printInorder(root.right);
    }
    
    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        Node root = buildTree(inorder,postorder);
        printInorder(root);
    }
}
