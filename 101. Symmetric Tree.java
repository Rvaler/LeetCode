/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        if(root == null)
            return true;
        
        ArrayList<TreeNode> left = new ArrayList<>();
        ArrayList<TreeNode> right = new ArrayList<>();
        
        createLeftListFromTree(left, root.left);
        createRightListFromTree(right, root.right);
        
        // Check if two arrays are equal
        
        if(left.size() == right.size()) {
            for(int i = 0; i < left.size(); i++) {
                TreeNode r = right.get(i);
                TreeNode l = left.get(i);
                
                if((l == null || r == null) && l != r)
                    return false;
            
                if(l != null && r != null && l.val != r.val) {
                    return false;
                }
                
                // System.out.println("Left " + (l != null ? l.val : "null"));
                // System.out.println("Right " + (r != null ? r.val : "null"));
            }
        } else {
            return false;
        }
        
        return true;
    }
    
    public void createLeftListFromTree(ArrayList<TreeNode> list, TreeNode node) {
        list.add(node);
        
        if(node != null) {
            createLeftListFromTree(list, node.left);
            createLeftListFromTree(list, node.right);    
        }
    }
    
    public void createRightListFromTree(ArrayList<TreeNode> list, TreeNode node) {
        list.add(node);
        
        if(node != null) {
            createRightListFromTree(list, node.right);
            createRightListFromTree(list, node.left);    
        }
    }
}