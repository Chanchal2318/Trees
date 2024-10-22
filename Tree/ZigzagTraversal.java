// Time Complexity: O(N) where N is the number of nodes in the binary tree. 
// Each node of the binary tree is enqueued and dequeued exactly once
// Space Complexity - O(N)

import java.util.*;
public class ZigzagTraversal {
    public static class Node{
        int data;
        Node right;
        Node left;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    public static List<List<Integer>> zigzagTraversal(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        
        // Queue for level-order traversal
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;
        
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> row = new ArrayList<>(Collections.nCopies(size, 0)); // Initialize list with size
            
            for(int i = 0; i < size; i++){
                Node currentNode = q.poll();
                int idx = leftToRight ? i : (size - 1 - i);
                row.set(idx, currentNode.data);  // Use set() as the size is already fixed
                
                if(currentNode.left != null) {
                    q.add(currentNode.left);
                }
                if(currentNode.right != null) {
                    q.add(currentNode.right);
                }
            }
            
            res.add(row);  // Add current level row to result
            leftToRight = !leftToRight;  // Flip the direction
        }
        return res;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        
        List<List<Integer>> result = zigzagTraversal(root);
        System.out.println(result);
    }
}
