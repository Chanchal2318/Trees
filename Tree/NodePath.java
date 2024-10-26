import java.util.*;
public class NodePath {
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
    public static boolean getPath(Node root, List<Integer>arr, int x){
        if(root == null){
            return false;
        }
        arr.add(root.data);
        if(root.data == x){
            return true;
        }
        if(getPath(root.left, arr, x) || getPath(root.right, arr, x)){
            return true;
        }
        arr.remove(arr.size()-1);
        return false;
    }
    public static List<Integer> solve(Node A, int B){
        List<Integer> arr = new ArrayList<>();
        if(A == null){
            return arr;
        }
        getPath(A, arr, B);
        return arr;
    }
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.right.left = new Node(0);
        root.right.right = new Node(8);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);
        System.out.println(solve(root, 7));
    }
}
