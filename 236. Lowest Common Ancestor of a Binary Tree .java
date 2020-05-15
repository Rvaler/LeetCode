/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// 4, 2, 3, 5
// 6, 5, 3

// Solution takes O(n) time complexity, and O(h) space complexity
// Calculates the path to both nodes, and then check for the lca

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(p == q)
            return p;
        
        List<TreeNode> pathToP = findPathTo(root, p, new ArrayList<>());
        List<TreeNode> pathToQ = findPathTo(root, q, new ArrayList<>());
        
        List<TreeNode> longer = pathToP.size() > pathToQ.size() ? pathToP : pathToQ;
        List<TreeNode> shorter = pathToP.size() > pathToQ.size() ? pathToQ : pathToP;
        
        int longerIndex = longer.size() - shorter.size();
        int shorterIndex = 0;
        
        while(longer.get(longerIndex) != shorter.get(shorterIndex)) {
            longerIndex++;
            shorterIndex++;
        }
        
        return longer.get(longerIndex);
    }
    
    public List<TreeNode> findPathTo(TreeNode current, TreeNode destination, List<TreeNode> path) {
        
        if(current == null)
            return null;
        
        if(current == destination) {
            path.add(current);    
            return path;
        }
            
        List<TreeNode> left = findPathTo(current.left, destination, path);
        if(left != null) {
            left.add(current);
            return left;
        }
          
        List<TreeNode> right = findPathTo(current.right, destination, path);
        if(right != null)
            right.add(current);
        return right;
    }
}