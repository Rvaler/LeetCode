/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


class Solution {
    public ListNode middleNode(ListNode head) {
        
        // Naive approach would be to count number of elements and then iterate to that index
        // O(N) time complexity, and O(1) space complexity
        // -------------------- Solution 1 --------------------
        /*
        int numElements = 0;
        ListNode current = head;
        
        // Counting num of elements in list
        while(current != null) {
            numElements++;
            current = current.next;
        }
        
        current = head;
        int middle = numElements / 2;
        while(middle > 0) {
            current = current.next;
            middle--;
        }
        
        return current;
        */
        
        // -------------------- Solution 2 --------------------
        // Small optimization by not having to count num of elements, but having one slow pointer that will iterate by 1 position, and a fast pointer that will iterate by 2 positions
        // When fast pointer reaches the end of list, slow pointer will be in the middle
        // Time and space complexities are still the same, even though we run in O(n/2), which is O(n)
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
}