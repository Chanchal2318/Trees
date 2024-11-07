import java.util.*;
public class Insert_Node {
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
    public static Node insertIntoBST(Node root, int data){
        if(root == null){
            return new Node(data);
        }
        Node curr = root;
        while(true){
            if(curr.data <= data){
                if(curr.right!= null){
                    curr = curr.right;
                }
                else{
                    curr.right = new Node(data);
                    break;
                }
            }
            else{
                if(curr.left != null){
                    curr= curr.left;
                }
                else{
                    curr.left = new Node(data);
                    break;
                }
            }
        }
        return root;
    }
    public static void printBST(Node root){
        if(root != null){
            printBST(root.left);
            System.out.print(root.data + " ");
            printBST(root.right);
        }
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(10);
        Node res = insertIntoBST(root,11);
        System.out.println(res.data);
        printBST(root);
    }
}
