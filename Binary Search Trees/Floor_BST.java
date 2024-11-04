import java.util.*;
public class Floor_BST {
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
    public static int smallestFloor(Node root , int key){
        int floor = -1;
        while(root != null){
            if(root.data == key){
                floor = root.data;
                return floor;
            }
            if(key < root.data){
                root = root.left;
            }
            else{
                floor = root.data;
                root = root.right;
            }
        }
        return floor;
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(10);
        System.out.println(smallestFloor(root,9));
    }
}
