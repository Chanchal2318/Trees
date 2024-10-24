import java.util.*;
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
public static class VerticalOrderTraversal{
public static List<List<Integer>> findVertical(Node root){
    Map<Integer,Map<Integer,TreeSet<Integer>>> nodes = new TreeMap<>();
    Queue<Pair<Node,Pair<Integer,Integer>>> todo = new LinkedList<>();
    todo.add(new Pair<>(root,new Pair<>(0,0)));
    while(!todo.isEmpty()) {
        Pair<Node,Pair<Integer, Integer>> p = todo.poll();
        Node temp = p.getKey();
        int x = p.getValue().getKey();
        int y = p.getValue().getValue();
        nodes.computeIfAbsent(x, k -> new TreeMap<>())
        .computeIfAbsent(y, k -> new TreeSet<>())
        .add(temp.data);
        if(temp.left != null){
            todo.add(new Pair<>(temp.left,new Pair<>(x-1,y+1)));
        }
        if(temp.right != null){
            todo.add(new Pair<>(temp.right,new Pair<>(x+1,y+1)));
        }
    }
    List<List<Integer>> ans = new ArrayList<>();
    for(Map.Entry<Integer, Map<Integer,TreeSet<Integer>>> entry:nodes.entrySet()){
        List<Integer> col = new ArrayList<>();
        for(TreeSet<Integer>set:entry.getValue().values()){
            col.addAll(set);
        }
        ans.add(col);
    }
    return ans;
}
    public static void printResult(List<List<Integer>> result){
        for(List<Integer> level:result){
            for(int node:level){
                System.out.print(node + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
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
        System.out.println(findVertical(root));
    }
}