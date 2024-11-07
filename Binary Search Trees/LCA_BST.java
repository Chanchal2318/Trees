import java.util.*;
public class LCA_BST {
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
    public static Node lowestCommonAncestor(Node root, Node p, Node q){
        if(root == null){
            return null;
        }
        int curr = root.data;
        if(curr < p.data && curr < q.data){
           return lowestCommonAncestor(root.right, p, q);
        }
        if(curr > p.data && curr > q.data){
            return lowestCommonAncestor(root.left,p,q);
        }
        return root;
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(10);
        Node ans = lowestCommonAncestor(root,root.right.right,root.right.left);
        System.out.println(ans.data);
    }
}
