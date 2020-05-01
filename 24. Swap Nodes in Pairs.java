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
    
    // Solution: Manage 2 pointers. 'Front' pointer will be 1 position forward of 'back' pointer
    // Switch positions and calculate next front and back pointer positions
    // Time complexity: O(n)
    // Space complexity: O(1)
    
    public ListNode swapPairs(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        
        ListNode front = head.next;
        ListNode back = head;
        
        ListNode newHead = front;
        
        while(front != null || back != null) {
        
            ListNode nextFront = front != null && front.next != null ? front.next.next : null;
            ListNode nextBack = back != null && back.next != null ? back.next.next : null;
            
            if(front != null)
                front.next = back;
            
            if(back != null)
                back.next = nextFront != null ? nextFront : nextBack;
            
            front = nextFront;
            back = nextBack;
        }
        
        return newHead;
    }
}