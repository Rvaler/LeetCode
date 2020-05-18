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

// Solution involves the creation of 2 pointers (current and next)
// Since the list is sorted, we can check for adjacent nodes to detect duplicates

// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        if(head == null)
            return null;
        
        ListNode current = head;
        ListNode next = head.next;
        
        while(next != null) {
            if(current.val == next.val) {
                current.next = next.next;
                next = current.next;
            } else {
                current = current.next;
                next = next.next;
            }
        }
        
        return head;
    }
}