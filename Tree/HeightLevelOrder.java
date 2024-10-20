import java.util.*;
public class HeightLevelOrder{
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
    public static int maxDepth(Node root){
        if(root == null){
            return 0;
        }
        Queue<Node> q = new LinkedList<>();
        int level = 0;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                Node front = q.poll();
                if(front.left != null){
                    q.add(front.left);
                }
                if(front.right != null){
                    q.add(front.right);
                }
            }
            level++;
        }
        return level;
    }
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(maxDepth(root));
    }
}