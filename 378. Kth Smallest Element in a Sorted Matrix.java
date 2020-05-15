class Solution {
    
    // 1) Solution: create and use a min heap to keep all elements in the matrix;
    // After that, remove k - 1 elements from the heap, the top one left is the answer
    // Time Complexity: O(n^2 * log(n)) to build heap and remove elements;
    // Space Complexity: O(n)
    
    public int kthSmallest(int[][] matrix, int k) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                minHeap.add(matrix[i][j]);
            }
        }
        
        for(int i = 1; i < k; i++) 
            minHeap.poll();
        
        return minHeap.poll();
    }
}