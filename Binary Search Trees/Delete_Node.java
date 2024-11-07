public class Delete_Node {
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
    public static Node deleteNode(Node root, int key){
        if(root == null){
            return null;
        }
        if(root.data == key){
            return helper(root);
        }
        Node dummy = root;
        while(root != null){
            if(root.data > key){
                if(root.left != null && root.left.data == key){
                    root.left = helper(root.left);
                    break;
                }
                else{
                    root = root.left;
                }
            }
            else{
                if(root.right != null && root.right.data == key){
                    root.right = helper(root.right);
                    break;
                }
                else{
                    root = root.right;
                }
            }
        }
        return dummy;
    }
    public static Node helper(Node root){
        if(root.left == null){
            return root.right;
        }
        else if(root.right == null){
            return root.left;
        }
        else{
            Node rightChild = root.right;
            Node lastRight = findLastRight(root.left);
            lastRight.right = rightChild;
            return root.left;
        }
    }
    public static Node findLastRight(Node root){
        if(root.right == null){
            return root;
        }
        return findLastRight(root);
    }
    public static void printBST(Node root){
        if(root != null){
            printBST(root.left);
            System.out.print(root.data + " ");
            printBST(root.right);
        }
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(10);
        Node res = deleteNode(root, 3);
        System.out.println(res.data);
        printBST(root);
    }
}
