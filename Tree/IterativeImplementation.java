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
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(preorderTraversal(root));

    }
}