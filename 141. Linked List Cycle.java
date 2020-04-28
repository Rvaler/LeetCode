/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// Singly linked list
// [1, 2, 3, 4, 2] = true
// [1, 2, 3, 4, 6] = false

public class Solution {
    public boolean hasCycle(ListNode head) {
        
        // -------------------- Solution 1 --------------------
        // Create a hashset and interate through list adding values to set, if already exists then return true
        // O(N) time complexity, N = number of nodes in my list
        // O(N) space complexity
        
        /*
        ListNode current = head;
        Set<ListNode> nodeSet = new HashSet<>();
        
        while(current != null) {
            if(nodeSet.contains(current))
                return true;
            nodeSet.add(current);
            current = current.next;
        }
        
        return false;
        */
        
        // -------------------- Solution 2 --------------------
        // Optimization: Use 2 pointers, 1 slow and 1 fast
        // Fast jumps 2 by 2 positions, while the slow jumps 1 by 1, if they meet eventually, then there is a loop
        // O(1) space complexity, still O(N) time complexity
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast)
                return true;
        }
        
        return false;
    }
}