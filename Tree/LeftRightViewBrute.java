import java.util.*;
public class LeftRightViewBrute {
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
    public static class Pair<U,V>{
        public final U first;
        public final V second;

        public Pair(U first, V second){
            this.first = first;
            this.second = second;
        }

        public U getKey(){
            return first;
        }

        public V getValue(){
            return second;
        }
    }
    public static List<Integer> rightsideView(Node root){
        List<Integer> res = new ArrayList<>();
        recursionRight(root,0,res);
        return res;
    }
    public static List<Integer> leftsideView(Node root){
        List<Integer> res = new ArrayList<>();
        recursionLeft(root, 0, res);
        return res;
    }
    public static void recursionLeft(Node root,int level,List<Integer>res){
        if(root == null){
            return;
        }
        if(res.size() == level){
            res.add(root.data);
        }
        recursionLeft(root.left, level+1, res);
        recursionLeft(root.right, level+1, res);
    }
    public static void recursionRight(Node root,int level,List<Integer>res){
        if(root == null){
            return;
        }
        if(res.size() == level){
            res.add(root.data);
        }    
        recursionRight(root.right, level+1, res);
        recursionRight(root.left, level+1, res);
    }
    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(10);
        root.right.left = new Node(9);
        System.out.println(rightsideView(root));
        System.out.println(leftsideView(root));
    }
}
