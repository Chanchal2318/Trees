import java.util.*;
public class MaximumWidth{
    public static class Pair<U,V>{
        
    }
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
    public static int maxWidth(Node root){
        if(root == null){
            return 0;
        }
        int ans = 0;
        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root,0));
        while(!q.isEmpty()){
            int size = q.size();
            int min = q.peek().getValue();
            int first,last;
            for(int i = 0;i<size;i++){
                int cur_id = q.peek().getValue()-min;
                Node node = q.peek().getKey();
            }
        }
    }
    public static void main(String[] args) {
        
    }
}