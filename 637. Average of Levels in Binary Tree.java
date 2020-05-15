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

// Solution involves to explore the tree using a BFS approach, and as we go down the levels we keep the sum of the nodes and the number of nodes of each level. 
// When we finish exploring that level we calculate the average and insert on result

// Time Complexity: O(N), number of nodes in my tree
// Space Complexity: O(L), the maximum number of nodes in a same level

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> result = new ArrayList<>();
        
        if(root == null)
            return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        
        long currentSum = 0;
        long levelNodes = 0;
        
        while(!q.isEmpty()) {
            TreeNode first = q.remove();
            
            if(first == null) { // end of level
                q.add(null); // add null to the end of next level
                result.add((double) currentSum / levelNodes);
                currentSum = 0;
                levelNodes = 0;
                
                if(q.peek() == null) // means that we have finished to explore the levels
                    q.remove();
                
            } else {
                currentSum += first.val;
                levelNodes++;
                
                // append children
                if(first.left != null)
                    q.add(first.left);
                if(first.right != null)
                    q.add(first.right);
            }
        }
        
        return result;
    }
}