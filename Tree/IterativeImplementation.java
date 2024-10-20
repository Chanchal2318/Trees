import java.util.*;
public class IterativeImplementation{
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
    public static List<Integer> preorderTraversal(Node root){
        // ArrayList to store preorder traversal
        List<Integer>preorder = new ArrayList<>();
        if(root == null){
            return preorder;
        }
        Stack<Node>st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            root = st.pop();
            preorder.add(root.data);
            if(root.right != null){
                st.push(root.right);
            }
            if(root.left != null){
                st.push(root.left);
            }
        }
        return preorder;
    }
    public static List<Integer> inorderTraversal(Node root) {
        // ArrayList to store inorder traversal
        List<Integer> inorder = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        Node current = root;
    
        while (current != null || !st.isEmpty()) {
            // Reach the leftmost node of the current Node
            while (current != null) {
                st.push(current);
                current = current.left;
            }
    
            // Current must be null at this point
            current = st.pop();
            inorder.add(current.data);
    
            // We have visited the node and its left subtree, now it's time to visit the right subtree
            current = current.right;
        }
        return inorder;
    }
    public static List<Integer> postorderTraversal(Node root) {
        List<Integer> postorder = new ArrayList<>();
        if (root == null) {
            return postorder;
        }
    
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
    
        st1.push(root);
        
        while (!st1.isEmpty()) {
            Node node = st1.pop();
            st2.push(node);
    
            // Push left and right children of the popped node to st1
            if (node.left != null) {
                st1.push(node.left);
            }
            if (node.right != null) {
                st1.push(node.right);
            }
        }
    
        // Pop all elements from st2 and add to postorder
        while (!st2.isEmpty()) {
            postorder.add(st2.pop().data);
        }
    
        return postorder;
    }
    
    
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(preorderTraversal(root));
        System.out.println(inorderTraversal(root));
        System.out.println(postorderTraversal(root));
    }
}