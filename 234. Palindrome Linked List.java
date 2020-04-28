/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


// Solution: move slow pointer 1 position each iteraction, and fast 2 positions each iteraction
// Meanwhile, put value of slow pointer in a stack, when fast pointer reaches end, slow will be in the middle, compare the restant of the list with stack
// Time complexity: O(n)
// Space complexity: O(n/2) = O(n)

class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null) {
            stack.push(slow.val);
            // if have and odd number of elements in my list, remove from stack and advance slow pointer;
            if(fast.next == null) { 
                stack.pop();
                slow = slow.next;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        
        while(!stack.isEmpty()) {
            Integer top = stack.pop();
            if(slow == null || slow.val != top)
                return false;
            slow = slow.next;
        }
        
        return true;
    }
}