class RandomizedSet {
    
    /*
    add 1, add 2, random, add 3, remove 1, add 7, add 4
    */
    
    // ArrayList
    // add: O(1)
    // getRandom: O(1)
    // remove:O(n) -> can remove in O(1) when removing from last position of array
    
    // HashMap
    // add: O(1)
    // remove:(1)
    // getRandom: O(n)
    
    // Keep a HashMap of nums to their positions in the array
    // Keep an arraylist of nums
    
    // when deleting a num, switch its position with the num in the last position in my array, and remove the last
    
    HashMap<Integer, Integer> mapNumToIndex;
    ArrayList<Integer> nums;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.mapNumToIndex = new HashMap<Integer, Integer>();
        this.nums = new ArrayList<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        
        if(!mapNumToIndex.containsKey(val)) {
            int index = nums.size();
            nums.add(val);
            mapNumToIndex.put(val, index);
            return true;
        }
        
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        
        if(mapNumToIndex.containsKey(val)) {
            // swap its position with the last index in my arraylist
            int valIndex = mapNumToIndex.get(val);
            int lastNumIndex = nums.size() - 1;
            
            swapNums(valIndex, lastNumIndex);
            
            // remove from arraylist and hashmap
            nums.remove(lastNumIndex);
            mapNumToIndex.remove(val);
            
            return true;
        } else {
            return false;
        }
    }
    
    private void swapNums(int valIndex, int lastNumIndex) {
        
        // swap arraylist
        int tmp = nums.get(valIndex);
        nums.set(valIndex, nums.get(lastNumIndex));
        nums.set(lastNumIndex, tmp);
        
        // swap hashmap
        mapNumToIndex.put(nums.get(valIndex), valIndex);
        mapNumToIndex.put(nums.get(lastNumIndex), lastNumIndex);
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        if(nums.isEmpty())
            return -1;
        
        int randomIndex = (int)(Math.random() * nums.size());
        return nums.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */