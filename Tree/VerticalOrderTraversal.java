// import java.util.*;
// public static class VerticalOrderTraversal{
//     public static class Node{
//         int data;
//         Node left;
//         Node right;
//         public Node(int data){
//             this.data = data;
//             this.left = null;
//             this.right = null;
//         }
//     }
// public static List<List<Integer>> findVertical(Node root){
//     Map<Integer,Map<Integer,TreeSet<Integer>>> nodes = new TreeMap<>();
//     Queue<Pair<Node,Pair<Integer,Integer>>> todo = new LinkedList<>();
//     todo.add(new Pair<>(root,new Pair<>(0,0)));
//     while(!todo.isEmpty()) {
//         Pair<Node,Pair<Integer, Integer>> p = todo.poll();
//         Node temp = p.getKey();
//         int x = p.getValue().getKey();
//         int y = p.getValue().getValue();
//         nodes.computeIfAbsent(x, k -> new TreeMap<>())
//         .computeIfAbsent(y, k -> new TreeSet<>())
//         .add(temp.data);
//         if(temp.left != null){
//             todo.add(new Pair<>(temp.left,new Pair<>(x-1,y+1)));
//         }
//         if(temp.right != null){
//             todo.add(new Pair<>(temp.right,new Pair<>(x+1,y+1)));
//         }
//     }
//     List<List<Integer>> ans = new ArrayList<>();
//     for(Map.Entry<Integer, Map<Integer,TreeSet<Integer>>> entry:nodes.entrySet()){
//         List<Integer> col = new ArrayList<>();
//         for(TreeSet<Integer>set:entry.getValue().values()){
//             col.addAll(set);
//         }
//         ans.add(col);
//     }
//     return ans;
// }
//     public static void printResult(List<List<Integer>> result){
//         for(List<Integer> level:result){
//             for(int node:level){
//                 System.out.print(node + " ");
//             }
//             System.out.println();
//         }
//         System.out.println();
//     }
//     public static void main(String[] args) {
//         Node root = new Node(1);
//         root.left = new Node(2);
//         root.left.left = new Node(4);
//         root.left.right = new Node(10);
//         root.left.left.right = new Node(5);
//         root.left.left.right.right = new Node(6);
//         root.right = new Node(3);
//         root.right.right = new Node(10);
//         root.right.left = new Node(9); 
//         System.out.println(findVertical(root));
//     }
// }


import java.util.*;

// Custom Pair class to replace Pair from the original code
class Pair<U, V> {
    public final U first;
    public final V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }

    public U getKey() {
        return first;
    }

    public V getValue() {
        return second;
    }
}

public class VerticalOrderTraversal {

    // Node class definition
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Method to find the vertical order traversal
    public static List<List<Integer>> findVertical(Node root) {
        // TreeMap to store the vertical order nodes
        Map<Integer, Map<Integer, TreeSet<Integer>>> nodes = new TreeMap<>();
        // Queue to store the nodes with their horizontal and vertical distances
        Queue<Pair<Node, Pair<Integer, Integer>>> todo = new LinkedList<>();
        todo.add(new Pair<>(root, new Pair<>(0, 0))); // Starting from the root node (x=0, y=0)

        // Perform level-order traversal
        while (!todo.isEmpty()) {
            Pair<Node, Pair<Integer, Integer>> p = todo.poll();
            Node temp = p.getKey();
            int x = p.getValue().getKey(); // Horizontal distance
            int y = p.getValue().getValue(); // Vertical distance

            // Insert the node data into the TreeMap
            nodes.computeIfAbsent(x, k -> new TreeMap<>())
                 .computeIfAbsent(y, k -> new TreeSet<>())
                 .add(temp.data);

            // Add the left and right children to the queue with updated positions
            if (temp.left != null) {
                todo.add(new Pair<>(temp.left, new Pair<>(x - 1, y + 1)));
            }
            if (temp.right != null) {
                todo.add(new Pair<>(temp.right, new Pair<>(x + 1, y + 1)));
            }
        }

        // Prepare the final result list
        List<List<Integer>> ans = new ArrayList<>();
        for (Map.Entry<Integer, Map<Integer, TreeSet<Integer>>> entry : nodes.entrySet()) {
            List<Integer> col = new ArrayList<>();
            for (TreeSet<Integer> set : entry.getValue().values()) {
                col.addAll(set);
            }
            ans.add(col);
        }

        return ans;
    }

    // Helper method to print the result
    public static void printResult(List<List<Integer>> result) {
        for (List<Integer> level : result) {
            for (int node : level) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Main method to test the vertical order traversal
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(10);
        root.right.left = new Node(9);

        List<List<Integer>> result = findVertical(root);
        printResult(result); // Print the result
    }
}
