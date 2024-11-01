import java.util.*;
public class MorrisPreorder {
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
    public static List<Integer> getPreorder(Node root){
        List<Integer> preorder = new ArrayList<>();
        Node curr = root;
        while(curr != null){
            if(curr.left == null){
                preorder.add(curr.data);
                curr = curr.right; 
            }
            else{
                Node prev = curr.left;
                while (prev.right != null && prev.right != curr){
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = curr;
                    preorder.add(curr.data);
                    curr = curr.left;
                }
                else{
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        return preorder;
    }    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        List<Integer> preorder = getPreorder(root);
        System.out.print("Binary Tree Morris Preorder Traversal : ");
        for(int i = 0;i<preorder.size();i++){
            System.out.print(preorder.get(i)+" ");
        }
        System.out.println();
    }
}
