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
    
    // Solution is implement a normal DFS in my tree, when reaching to a leaf, returning 0
    // After that, calculate the current path in a bottom up approach by summing lenghts of right + left
    // Compare to a global max and return the maximum length of left and right subtrees.
    
    // Time complexity: O(N), num of nodes in my tree
    // Space Complexity: O(H), height of tree
    
    public int globalMax = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        dfsTree(root);
        return globalMax;
    }
    
    public int dfsTree(TreeNode node) {
        
        if(node == null)
            return 0;
        
        int left = dfsTree(node.left);
        int right = dfsTree(node.right);
        
        int currentPath = left + right;
        globalMax = Math.max(globalMax, currentPath);
        
        // return longest subtree path adding current node to path
        return Math.max(left, right) + 1; 
    }
    
}