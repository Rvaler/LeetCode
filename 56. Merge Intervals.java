class Solution {
    
    // Solution involves to sort the intervals array based on their start dates
    // After that, we look for adjacent intervals that could be merged, when that is not possible we update our result with the new merged interval
    
    // Time Complexity: O(n log(n)) to sort + O(n) to merge intervals, 
    // Space Complexity: O(n) required to store the result;
    // n = number of intervals
    
    public int[][] merge(int[][] intervals) {
        
        // base case
        if(intervals == null || intervals.length == 0)
            return new int[0][0];
        
        // sort based on start date, which is represented on column 0
        Arrays.sort(intervals, new Comparator<int[]>() {
            
            @Override
            public int compare(final int[] entry1, final int[] entry2) {
                if(entry1[0] > entry2[0])
                    return 1;
                else if(entry1[0] < entry2[0])
                    return -1;
                else
                    return 0;
            }
        });
        
        List<int[]> merged = new ArrayList<>();
        
        int startTime = intervals[0][0];
        int endTime = intervals[0][1];

        for(int i = 1; i < intervals.length; i++) {
            
            int currentStartTime = intervals[i][0];
            int currentEndTime = intervals[i][1];
            
            // if possible, merge intervals
            if(endTime >= currentStartTime) {
                // they intersect
                endTime = Math.max(endTime, currentEndTime);
            } else {
                // otherwise, insert interval to result and start a new interval
                addPairToResult(startTime, endTime, merged);
                
                startTime = currentStartTime;
                endTime = currentEndTime;
            }
        }
        
        // add final merged pair
        addPairToResult(startTime, endTime, merged);
        
        return convertResult(merged);
    }
    
    public void addPairToResult(int startTime, int endTime, List<int[]> merged) {
        int[] pair = new int[2];
        pair[0] = startTime;
        pair[1] = endTime;
        merged.add(pair);
    }
    
    public int[][] convertResult(List<int[]> merged) {
        // Convert List<int[]> to int[][]
        int[][] result = new int[merged.size()][2];
        for(int i = 0; i< merged.size(); i++) {
            result[i][0] = merged.get(i)[0];
            result[i][1] = merged.get(i)[1];
        }
        
        return result;
    }
}