class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        
        int[] timeNeeded = new int[N];
        Arrays.fill(timeNeeded, Integer.MAX_VALUE);
        
        int[][] adjacentMatrix = new int[N][N];
        for(int[] col: adjacentMatrix)
            Arrays.fill(col, -1);
        
        for(int[] time : times) {
            int from = time[0] - 1;
            int to = time[1] - 1;
            int weight = time[2];
            adjacentMatrix[from][to] = weight;
        }
        
        findShortestPath(adjacentMatrix, K - 1, timeNeeded, 0);
        
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < timeNeeded.length; i++) {
            if(i != K - 1) { // should discard origin node
                if(timeNeeded[i] == Integer.MAX_VALUE) // do not have path to all nodes
                    return -1;
                max = Math.max(max, timeNeeded[i]);
            }
        }
        
        return max;
    }
    
    public void findShortestPath(int[][] adjacentMatrix, int from, int[] timeNeeded, int currentTime) {
        
        for(int to = 0; to < adjacentMatrix.length; to++) {
            
            // there is a path to that node and this path is shorter than the one previous
            if(adjacentMatrix[from][to] != -1 && timeNeeded[to] > currentTime + adjacentMatrix[from][to]) { 
                timeNeeded[to] = currentTime + adjacentMatrix[from][to];
                findShortestPath(adjacentMatrix, to, timeNeeded, timeNeeded[to]);
            }
        }
        
    }
}