/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    // Solution:
    // 1) Create a hashmap Integer: Node
    // 2) Do a BFS in input, meanwhile, create nodes that are not in the hashmap, or reference to nodes already created
    
    // Time complexity: O(V+E), where V stands for the number of vertices and E the number of edges
    // Space complexity: O(V)
    
    public Node cloneGraph(Node node) {
        
        if(node == null)
            return null;
        
        Map<Integer, Node> map = new HashMap<>();
        
        
        return bfsNode(node, map);
    }
    
    public Node bfsNode(Node node, Map<Integer, Node> map) {
        
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        
        while(!q.isEmpty()) {
            
            Node first = q.remove();
            
            Node clonedFirst = null;
            if(map.get(first.val) == null) {
                clonedFirst = new Node(first.val);
                map.put(first.val, clonedFirst);
            } else {
                clonedFirst = map.get(first.val);
            }
            
            for(Node neighbor: first.neighbors) {
                Node clonedNeighbor = null;
                if(map.get(neighbor.val) != null) {
                    clonedNeighbor = map.get(neighbor.val);
                } else {
                    clonedNeighbor = new Node(neighbor.val);
                    map.put(neighbor.val, clonedNeighbor);
                    q.add(neighbor);
                }
                
                clonedFirst.neighbors.add(clonedNeighbor);
            }
            
        }
        
        return map.get(1);
    }
    
    
}