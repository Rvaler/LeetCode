/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    // Solution: keep a pointer for each list, and iterate through both of them updating the list as we keep the order by choosing always the smaller element;
    // Time complexity: O(l1 + l2)
    // Space complexity: O(1), since we are not using any aditional memory besides the lists that we receive as input.
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        // Base cases
        if(l1 == null && l2 == null)
            return null;
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        
        ListNode resultHead = null;
        ListNode resultCurrent = null;
        ListNode currentL1 = l1;
        ListNode currentL2 = l2;
        
        while(currentL1 != null || currentL2 != null) {
            ListNode nextResult = null;
            if(currentL1 == null) {
                nextResult = currentL2;
                currentL2 = currentL2.next;
            } else if(currentL2 == null) {
                nextResult = currentL1;
                currentL1 = currentL1.next;
            } else { // none of them are null
                if(currentL1.val < currentL2.val) {
                    nextResult = currentL1;
                    currentL1 = currentL1.next;
                } else {
                    nextResult = currentL2;
                    currentL2 = currentL2.next;
                }
            }
            
            if(resultHead == null) {
                resultHead = nextResult;
                resultCurrent = resultHead;
            } else {
                resultCurrent.next = nextResult;
                resultCurrent = resultCurrent.next;
            }
        }
        
        return resultHead;
    }
}