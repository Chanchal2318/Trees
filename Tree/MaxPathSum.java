// Max Path Sum
import java.util.*;
public class MaxPathSum {
    public static class Node{
        int data;
        Node right;
        Node left;
        public Node(int data){
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }
    public static int findMaxPathSum(Node root, int[] maxi){
        if(root == null){
            return 0;
        }
        int leftMaxPath = Math.max(0,findMaxPathSum(root.left,maxi));
        int rightMaxPath = Math.max(0,findMaxPathSum(root.right, maxi));
        // Update the overall maximum path including current node
        maxi[0] = Math.max(maxi[0], leftMaxPath+rightMaxPath);
        return Math.max(leftMaxPath,rightMaxPath)+root.data;
    }
    public static int maxPathSum(Node root){
        int maxi[] =  {Integer.MIN_VALUE};
        findMaxPathSum(root, maxi);
        return maxi[0];
    }
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);
        System.out.println("Maximum Path Sum:"+maxPathSum(root));
    }
}
