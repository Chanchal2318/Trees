import java.util.*;
public class Serialize_Deserialize {
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
    public static String serialize(Node root){
        if(root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node currNode = q.poll();
            if(currNode == null){
                sb.append("#,");
            }
            else{
                sb.append(currNode.data).append(",");
                q.offer(currNode.left);
                q.offer(currNode.right);
            }
        }
        return sb.toString();
    }
    public static Node deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] values = data.split(",");
        Node root = new Node(Integer.parseInt(values[0]));
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (!values[i].equals("#")) {
                Node leftNode = new Node(Integer.parseInt(values[i]));
                node.left = leftNode;
                q.offer(leftNode);
            }
            i++;
            if (!values[i].equals("#")) {
                Node rightNode = new Node(Integer.parseInt(values[i]));
                node.right = rightNode;
                q.offer(rightNode);
            }
            i++;
        }
        return root;
    }    
    public static void inorder(Node root){
        if(root == null){
           return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        System.out.print("Original Tree :");
        inorder(root);
        System.out.println();
        String serialized = serialize(root);
        System.out.println("Serialized : "+serialized);
        Node deserialized = deserialize(serialized);
        System.out.print("Tree after deserialization : ");
        inorder(deserialized);
        System.out.println();
        
    }
}
