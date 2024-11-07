public class K_Smallest_Largest{
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
    public static void reverseInorder(Node root, int[] counter, int k, int[] largest){
        if(root == null || counter[0] >= k){
            return;
        }
            // Traverse right subtree
            reverseInorder(root.right, counter, k, largest);
            // Increment counter after visiting right subtree
            counter[0]++;
            // Check if current node is the Kth largest
            if(counter[0] == k){
                largest[0] = root.data;
                return;
            }
            // Traverse left subtree if Kth largest is not found yet
            reverseInorder(root.left, counter, k, largest);
    }
    public static void inorder(Node root,int[] counter,int k,int [] smallest){
        if(root == null || counter[0] >= k){
            return;
        }
        // Traverse left subtree
        inorder(root.left, counter, k, smallest);
        // Increment counter after visiting left subtree
        counter[0]++;
        // Check if current node is the Kth smallest
        if (counter[0] == k) {
            smallest[0] = root.data;
            return;
        }
        // Traverse right subtree if Kth smallest is not found yet
        inorder(root.right, counter, k, smallest);
    }
    public static int[] findKth(Node root, int k){
        int[] smallest = new int[] {Integer.MIN_VALUE};
        int[] largest = new int[] {Integer.MIN_VALUE};
        int[] counter = new int[]{0};
        inorder(root, counter, k, smallest);
        counter[0] = 0;
        reverseInorder(root, counter, k, largest);
        return new int[]{smallest[0], largest[0]};
    }
    public static void printInorder(Node root){
        if(root == null){
            return;
        }
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }
    public static void main(String[] args){
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(10);
        int k = 3;
        int[] kthElement = findKth(root, k);
        System.out.println("Kth smallest element: " + kthElement[0]);
        System.out.println("Kth largest element: " + kthElement[1]);
    }
}