/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// ------ Solution 1: count the number of elements in my list O(n), then start again and remove (numElements - n) element
// Time and Space complexity = O(n)

// ------ Solution 2: 
// 1) Move forward one pointer n positions
// 2) Move 2 pointers simultaneosuly, one from head and the forward pointer till it reaches the end of list
// 3) When that happens, the back node will be one position before the node that it should be removed

// Optimized because it only iterates one time the linked list
// Time and Space complexity = O(n)

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        // ----------- Solution 1 ----------------
        
//         int numElements = 0;
//         ListNode current = head;
        
//         // Count num elements
//         while(current != null) {
//             current = current.next;
//             numElements++;
//         }
        
//         int indexToRemove = numElements - n;
//         current = head;
//         while(indexToRemove > 1) {
//             current = current.next;
//             indexToRemove--;
//         }
        
//         // Remove Element
//         if(indexToRemove == 0) {
//             head = head.next;
//         } else {
//             current.next = current.next.next;    
//         }
//         return head;
        
        // ----------- Solution 2 ----------------
        
        ListNode front = head;
        ListNode behind = head;
        
        // Move fron pointer n positions forward
        for(int i = 0; i < n; i++)
            front = front.next;
        
        while(front != null && front.next != null) {
            front = front.next;
            behind = behind.next;
        }
        
        if(behind == head && front == null) {
            head = head.next;
        } else {
            behind.next = behind.next.next;
        }
        
        return head;
    }
}