class Solution {
    
    // numCourses: 5, [0, 1, 2, 3, 4]
    // prerequisites: [(0, 1)] to take course 0, I must first take course 1
    
    // Solution 1: Create graph with nodes 
    // Node { num, List<Node> children, int incomingEdges}
    // Iterate through list of graph nodes searching for a node with incoming edges == 0
    // When found, descrease its children incoming edges by 1, remove node from graph, and repeat process 
    
    public class Node {
        public int num;
        public List<Integer> children;
        public int incomingEdges;
        
        public Node(int num) {
            this.num = num;
            this.children = new ArrayList<>();
            this.incomingEdges = 0;
        }
    }
  
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Node> mapNumToNode = new HashMap<>();
        
        for(int i = 0; i < numCourses; i++)
            mapNumToNode.put(i, new Node(i));
        
        for(int[] p: prerequisites) {
            Node nodeTo = mapNumToNode.get(p[0]);
            Node nodeFrom = mapNumToNode.get(p[1]);
            
            nodeTo.incomingEdges++;
            nodeFrom.children.add(nodeTo.num);
        }
        
        while(!mapNumToNode.isEmpty()) {
            
            Node node = null;
            for(Map.Entry<Integer, Node> entry : mapNumToNode.entrySet()) {
                if(entry.getValue().incomingEdges == 0) {
                    node = entry.getValue();
                    break;
                }   
            }
            
            // could not find a node with no incoming edges
            if(node == null)
                return false;
                
            doCourse(node, mapNumToNode);
            mapNumToNode.remove(node.num);
        }
        
        // graph is empty, which means that courses are doable
        return true;
    }
    
    public void doCourse(Node node, Map<Integer, Node> map) {
        
        for(int children: node.children) {
            if(map.get(children) != null) {
                map.get(children).incomingEdges--;
            }
        }
    }
}