/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


// Approach works by iterating through both lists, addings its values and carrying extra if necessary, repreat til both pinters are null

// Time Complexity: O(l1 + l2), 
// space complexity: O(max(l1, l2) + 1), since we will need this amount of nodes to generate its sum
// For example: 999(3 digits) + 999(3 digits) = 1998(4 digits)
         

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode resultHead = null;
        ListNode resultCurrent = null;
        
        int increment = 0;
        while(l1 != null || l2 != null || increment > 0) {
            int sum = increment;
            if(l1 != null) 
                sum += l1.val;
            if(l2 != null)
                sum += l2.val;
            
            // digit for this position is greater than 10
            if(sum >= 10) {
                increment = 1;
                sum = sum % 10;
            } else {
                increment = 0;
            }
            
            ListNode node = new ListNode();
            node.val = sum;
            
            if(resultHead == null) {
                resultHead = node;
                resultCurrent = node;
            } else {
                resultCurrent.next = node;
                resultCurrent = resultCurrent.next;
            }
            
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        
        return resultHead;
    }
}