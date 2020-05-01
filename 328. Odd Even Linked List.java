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
    
    // Solution: Maintain two pointers to the tail of two lists, and iterate through list.
    // While iterating, insert those nodes to the end of the respective list, even or odd
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    
    public ListNode oddEvenList(ListNode head) {
        
        // base cases
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        
        ListNode current = head;
        ListNode tailOdd = null;
        ListNode tailEven = null;
        
        boolean isOdd = true; // first index is considered odd
        
        while(current != null) {
            ListNode next = current.next;
            
            if(isOdd) {
                if(tailOdd != null) {
                    current.next = tailOdd.next;
                    tailOdd.next = current;
                    tailOdd = current;
                } else {
                    tailOdd = current;
                }
            } else {
                // is Even
                if(tailEven != null) {
                    tailEven.next = current;    
                } 
                tailEven = current;
                tailEven.next = null;
            }
            
            current = next;
            isOdd = !isOdd;
        }
        
        return head;
    }
}