class Solution {
    
    // N people labeled from 1 to N
    // Town Judge trusts nobody, and everybody trusts town judge
    // input: [pairs(a, b)] : peson a trusts person b
    
    
    // [(a, b), (c, b), (a, c), (d, b)] : Town Judge is b
    
    // 1) Create HashMap
    // map of node to pair of (int, int) : (income edges, outgoing edges)
    // a : (1, 0)
    // b : (0, 3)
    // c : (1, 0)
    // d : (1, 0)
    
    // 2) Iterate through hashmap and find node with 0 outgoing edges, and n - 1 incoming edges
    // num of nodes: hashset.size() = 4
    
    // Solution: O(N) time and space complexity
    
    public class Connection {
        public int outgoing;
        public int incoming;
        
        public Connection(int outgoing, int incoming) {
            this.outgoing = outgoing;
            this.incoming = incoming;
        }
    }
    
    public int findJudge(int N, int[][] trust) {
        // 1) 
        Map<Integer, Connection> map = new HashMap<>();
        
        for(int i = 1; i <= N; i++) 
            map.put(i, new Connection(0, 0));
        
        for(int[] t: trust) {
            int from = t[0];
            int to = t[1];

            Connection cFrom = map.get(from);
            Connection cTo = map.get(to);
            cFrom.outgoing += 1;
            cTo.incoming += 1;
            
            map.put(from, cFrom);
            map.put(to, cTo);
        }
        
        // 2)
        for(Map.Entry<Integer, Connection> entry: map.entrySet()) {
            Integer key = entry.getKey();
            Connection c = entry.getValue();
            if(c.incoming == N - 1 && c.outgoing == 0)
                return key;
        }
        
        return -1;
    }
}