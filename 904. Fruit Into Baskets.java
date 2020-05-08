class Solution {
 
    
    // Solution: 
    // Time Complexity: O(n)
    // Space Complexity: O(1), even tho we have a map, its maximum size will always be 3
    
    public int totalFruit(int[] tree) {
        
        int maxFruits = Integer.MIN_VALUE;
        
        // map will keep the pair <Tree Type, Count>
        // map will be used to keep the number of that tree type counts of my window solution
        HashMap<Integer, Integer> map = new HashMap<>(); 

        int start = 0;
        int end = 0;
        
        while(end < tree.length) {
            
            Integer value = map.get(tree[end]);
            // still not had 2 different types or type is the same as a current value
            if(map.size() < 2 || value != null) {
                if(value != null)
                    map.put(tree[end], map.get(tree[end]) + 1);
                else
                    map.put(tree[end], 1);
                end++;
                maxFruits = Math.max(maxFruits, getSum(map));
            } else {
                map.put(tree[start], map.get(tree[start]) - 1);
                if(map.get(tree[start]) == 0)
                    map.remove(tree[start]);
                start++;
            }
        }
        
        return maxFruits;
    }

    // aux function to get the sum of the elements in the map 
    int getSum(HashMap<Integer, Integer> map) {
        int sum = 0;
        for (Map.Entry mapElement : map.entrySet()) { 
            int value = ((int)mapElement.getValue()); 
            sum += value;
        }
        return sum;
    }
}