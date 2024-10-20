import java.util.*;
public class BFSTraversalInOneFlow {
    public class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static List<List<Integer>> preInPostTraversal(Node root) {
        // Lists to store the results of each traversal
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();

        // If the tree is empty, return an empty list
        if (root == null) {
            return new ArrayList<>();
        }

        // Stack to maintain nodes and their traversal state
        Stack<Pair<Node, Integer>> stack = new Stack<>();

        // Start with the root node and state 1 (preorder)
        stack.push(new Pair<>(root, 1));

        // Iterate through the tree
        while (!stack.isEmpty()) {
            Pair<Node, Integer> current = stack.pop();

            // Preorder traversal (1st visit)
            if (current.getValue() == 1) {
                preOrder.add(current.getKey().data);
                current.setValue(2); // Move to state 2 (inorder)
                stack.push(current);

                // If there is a left child, push it onto the stack
                if (current.getKey().left != null) {
                    stack.push(new Pair<>(current.getKey().left, 1));
                }
            }

            // Inorder traversal (2nd visit)
            else if (current.getValue() == 2) {
                inOrder.add(current.getKey().data);
                current.setValue(3); // Move to state 3 (postorder)
                stack.push(current);

                // If there is a right child, push it onto the stack
                if (current.getKey().right != null) {
                    stack.push(new Pair<>(current.getKey().right, 1));
                }
            }

            // Postorder traversal (3rd visit)
            else {
                postOrder.add(current.getKey().data);
            }
        }

        // Combine the results into a single list of lists
        List<List<Integer>> result = new ArrayList<>();
        result.add(preOrder);
        result.add(inOrder);
        result.add(postOrder);

        return result;
    }
    public static void main(String[] args) {
        
    }
}
