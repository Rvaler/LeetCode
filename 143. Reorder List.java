/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    
    // Solution 2: O(N) time complexity, but would have O(1) space complexity
    // 1) Find middle of list
    // 2) Reverse last half of list
    // 3) Intercalate pointers from first half to second half
    
    public void reorderList(ListNode head) {
       // 1) Find middle element
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        // 2) Reverse list
        ListNode mid = slow; // first element after middle point
        ListNode reversed = reverseList(mid);
        
        // 3) Intercalate normal list with reversed
        ListNode result = head;
        while(result != null && reversed != null) {
            ListNode resultNext = result.next;
            ListNode reversedNext = reversed.next;
            
            result.next = reversed;
            reversed.next = resultNext;
            
            result = resultNext;
            reversed = reversedNext;
        }
     
        if(result != null )
            result.next = null;
    }
    
    public ListNode reverseList(ListNode head) {
        
        if(head == null)
            return null;
    
        ListNode current = head;
        ListNode next = current.next;
        ListNode tail = head;
        
        while(current != null && next != null) {
            ListNode nextNext = next.next;
            
            next.next = current;
            current = next;
            next = nextNext;
        }
        tail.next = null;
        return current;
    }
    
    // Solution 1: O(n) time complexity, O(n) space complexity
    // Using stack to compare two halves of list
    
    /*
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        
        ListNode n = head;
        while(n != null) {
            stack.push(n);
            n = n.next;
        }
        
        n = head;
        int numElements = stack.size();
        while(stack.size() > numElements / 2) {
            ListNode next = n.next;
            ListNode top = stack.pop();
            
            if(n != top) {
                n.next = top;
                top.next = next;
                n = next;    
            }
        }
        
        // nullify tail of list
        if(n != null)
            n.next = null;
    }
    */
}