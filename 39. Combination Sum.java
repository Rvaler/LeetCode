class Solution {
    
    // [2,3,6,7]
    // (2) -> (2, 2), 
    // (3) -> (3, 3)
    // (4) -> 
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0)
            return result;
        
        List<Integer> list = new ArrayList<>();
        generatePermutations(candidates, target, 0, 0, list, result);
        return result;
    }
    
    public void generatePermutations(int[] candidates, int target, int index, 
                                     int currentSum, 
                                     List<Integer> currentList, 
                                     List<List<Integer>> result) {
        
        if(currentSum == target) { // add to result
            result.add(new ArrayList<>(currentList));
            return;
        }
        
        if(currentSum > target) {
            return;
        }
        
        if(index >= candidates.length) {
            return;
        }
        
        // permutation adding current index to result;
        currentList.add(candidates[index]);
        generatePermutations(candidates, target, index, currentSum + candidates[index], currentList, result);
        
        // permutation by not adding current index to result;
        currentList.remove(currentList.size() - 1);
        generatePermutations(candidates, target, index + 1, currentSum, currentList, result);

    }
}