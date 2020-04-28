class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        
        subsets.add(new ArrayList<Integer>()); // empty subset
        
        for(int num: nums) {
            List<List<Integer>> moreSubsets = new ArrayList<List<Integer>>();
            for(List<Integer> subset: subsets) {
                List<Integer> newSubset = new ArrayList<Integer>(subset);
                newSubset.add(num);
                moreSubsets.add(newSubset);
            }
            subsets.addAll(moreSubsets);
        }
        
        return subsets;
    }
}