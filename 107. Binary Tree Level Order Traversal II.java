/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    // O(N) space and time complexities, where N is the number of nodes in my tree
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        
        if(root == null)
            return levels;
        
        exploreNode(root, 0, levels); // levels appear in order
        Collections.reverse(levels); // reversing levels
        
        return levels;  
    }
    
    
    // Time complexity = O(n)
    // Space complexity = O(h), height of tree
    public void exploreNode(TreeNode node, int level, List<List<Integer>> levels) {
        
        if(node == null) // base case
            return;
        
        if(levels.size() == level) // should append a new level to my list
            levels.add(new ArrayList<Integer>());
        
        levels.get(level).add(node.val);
        exploreNode(node.left, level + 1, levels);
        exploreNode(node.right, level + 1, levels);
    }
}