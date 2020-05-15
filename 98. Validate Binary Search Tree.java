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

// Solution involves to iterate through my tree in a normal DFS approach, updating the max and min values as I go further
// Min value is updated when exploring right
// Max value is updated when exploring left
// 
// O(N) Time complexity
// O(H) Space complexity, H is the height of the tree

class Solution {
    public boolean isValidBST(TreeNode root) {
        return validateBST(root, null, null);
    }
    
    public boolean validateBST(TreeNode node, Integer min, Integer max) {
        if(node == null)
            return true;
        
        if(min != null && node.val <= min)
            return false;
        
        if(max != null && node.val >= max)
            return false;
        
        return validateBST(node.left, min, node.val) &&
            validateBST(node.right, node.val, max);
    }
}