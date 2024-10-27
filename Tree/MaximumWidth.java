import java.util.*;
public class MaximumWidth{
    public static class Pair<U,V>{
        public final U first;
        public final V second;
        public Pair(U first,V second){
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
    public static int widthOfBt(Node root){
        if(root == null){
            return 0;
        }
        int ans = 0;
        Queue<Pair<Node,Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root,0));
        while(!q.isEmpty()){
            int size = q.size();
            int min = q.peek().getValue();
            int first = 0,last=0;
            for(int i = 0;i<size;i++){
                int cur_id = q.peek().getValue()-min;
                Node node = q.peek().getKey();
                q.poll();
                if(i == 0){
                    first = cur_id;
                }
                if(i == size-1){
                    last = cur_id;
                }
                if(node.left != null){
                    q.add(new Pair<>(node.left,cur_id*2+1));
                }
                if(node.right != null){
                    q.add(new Pair<>(node.right,cur_id*2+2));
                }
            }
            ans = Math.max(ans,last-first+1);
        }
        return ans;
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
        System.out.println(widthOfBt(root));
    }
}