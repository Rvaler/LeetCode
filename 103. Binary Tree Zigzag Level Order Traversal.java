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

// Solution involves the exploration through a BFS, using two Stacks to keep the current and next levels
// The stacks are used in order to reverse the order (left to right / right to left) for each new level
// Time Complexity: O(n), number of nodes in my tree;
// Space Complexity: O(l) + O(h), l: number of nodes in a same level; h: number of levels in my tree
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null)
            return result;
        
        Stack<TreeNode> currentLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        
        currentLevel.add(root);
        boolean leftToRight = true;
        
        while(true) {
            List<Integer> currentResult = new ArrayList<>();
            while(!currentLevel.isEmpty()) {
                TreeNode first = currentLevel.pop();
                currentResult.add(first.val);
                
                // add sons
                if(leftToRight) {
                    if(first.left != null)
                        nextLevel.add(first.left);
                    if(first.right != null)
                        nextLevel.add(first.right);
                } else {
                    if(first.right != null)
                        nextLevel.add(first.right);
                    if(first.left != null)
                        nextLevel.add(first.left);
                }
            }
            
            result.add(currentResult);
            leftToRight = !leftToRight;
            
            // currentLevel is empty now
            if(nextLevel.isEmpty()) {
                break; // exploration ended
            } else { // switch current level and next level stack pointers
                Stack<TreeNode> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
        
        return result;
    }
}