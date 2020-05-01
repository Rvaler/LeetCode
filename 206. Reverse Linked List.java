/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    // Current node, Next node, NextNext
    // Repeat til next is null
    // next.next = current
    // current = next
    // next = nextNext

    
    // Iterative Solution: iterate through list and invert pointers
    // Time Complexity: O(n), number of nodes in my list
    // Space Complexity: O(1)
    
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        
        ListNode current = head;
        ListNode next = head.next;
        
        while(next != null) {
            ListNode nextNext = next.next;
            next.next = current;
            
            // Advance
            current = next;
            next = nextNext;
        }
        
        head.next = null; // Nullify tail
        return current;
    }
    
    // Recursive Approach
    // Time complexity: O(n)
    // Space complexity: O(n), due to the recursive calls
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        
        ListNode next = head.next;
        
        if(next == null)
            return head;
        
        head.next = null;
        
        return reverseListRecursively(head, next);
    }
    
    public ListNode reverseListRecursively(ListNode previousNode, ListNode currentNode) {
        ListNode next = currentNode.next;
        currentNode.next = previousNode;
        
        if(next == null)
            return currentNode;
        
        return reverseListRecursively(currentNode, next);
    }
}