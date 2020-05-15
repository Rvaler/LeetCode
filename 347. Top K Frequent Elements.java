class Solution {
    
    // Solution is 
    // 1) Create a hashMap that will keep the number of occurrences for the ints in nums
    // 2) Crete a heap with size K, and insert all elements of my hashmap
    // Time Complexity: O(n) + O(n log(k))
    
    public int[] topKFrequent(int[] nums, int k) {
        
        // 1)
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1); 
        }
        
        // 2)
        // init heap 'the less frequent element first'
        // This defines the comparator function that the priority queue will use, using the value of my hashmap instead of the key
        PriorityQueue<Integer> heap =
            new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));

        // keep k top frequent elements in the heap
        for (int n: count.keySet()) {
          heap.add(n);
          if (heap.size() > k)
            heap.poll();
        }
    
        // build output list
        int[] topK = new int[k];
        int index = 0;
        while (!heap.isEmpty()){
            topK[index] = heap.poll();
            index++;
        }
        
        return topK;
        
    }
}