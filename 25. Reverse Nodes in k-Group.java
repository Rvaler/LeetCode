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

// 1) Change pointers to begin and end of list that should be reversed;
// 2) Reverse list and put tail.next = reverse of next list

// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null)
            return null;
        
        ListNode newHead = null;
        
        ListNode begin = head;
        ListNode end = head;
        
        ListNode previousTail = null;
        
        while(begin != null) {
            
            // advance end k positions
            for(int i = 1; i < k; i++) {
                end = end.next;
                if(end == null) // not enough space in the end of list to reverse
                    return newHead != null ? newHead : head;
            }

            ListNode next = end.next;
            // Reverse sublist from begin to end
            ListNode reversedHead = reverseList(begin, end);
            if(newHead == null) // first reversed list head is now the list head;
                newHead = reversedHead;
                
            begin.next = next; // reversed list tail should point to previous next
            if(previousTail != null) // previous tail should point to reversed head
                previousTail.next = end;
            previousTail = begin;

            // Advance
            begin = next;
            end = next;
        }
        
        return newHead != null ? newHead : head;
    }
    
    
    // Aux function to reverse a list from begin to end nodes
    public ListNode reverseList(ListNode begin, ListNode end) {
        
        // base cases
        if(begin == null || end == null)
            return null;
        
        if(begin == end)
            return begin;
        
        ListNode current = begin;
        ListNode next = current.next;
        
        while(next != null && current != end) {
            ListNode nextNext = next.next;
            next.next = current;
            
            current = next;
            next = nextNext;
        }
        
        return current; // new head of list
    }
}