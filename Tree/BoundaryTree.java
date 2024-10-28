import java.util.*;
public class BoundaryTree{
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
    public static boolean isLeaf(Node root){
        return root.left == null && root.right == null;
    }
    public static void addLeftBoundary(Node root, List<Integer> res){
        Node curr = root.left;
        while(curr != null){
            if(!isLeaf(curr)){
                res.add(curr.data);
            }
            if(curr.left != null){
                curr = curr.left;
            }
            else{
                curr =curr.right;
            }
        }
    }
    public static void addRightBoundary(Node root, List<Integer>res){
        Node curr = root.right;
        List<Integer> temp = new ArrayList<>();
        while(curr != null){
            if(!isLeaf(curr)){
                temp.add(curr.data);
            }
            if(curr.right != null){
                curr = curr.right;
            }
            else{
                curr = curr.left;
            }
        }
        for(int i = temp.size()-1 ; i>=0; i--){
            res.add(temp.get(i));
        }
    }
    public static void addLeaves(Node root,List<Integer> res){
        if(isLeaf(root)){
            res.add(root.data);
            return;
        }
        if(root.left != null){
            addLeaves(root.left,res);
        }
        if(root.right != null){
            addLeaves(root.right,res);
        }
    }
    public static List<Integer> printBoundary(Node root){
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        if(!isLeaf(root)){
            res.add(root.data);
        }
        addLeftBoundary(root,res);
        addLeaves(root,res);
        addRightBoundary(root,res);
        return res;
    }
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(printBoundary(root));
    }
}