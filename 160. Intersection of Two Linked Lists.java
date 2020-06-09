/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// Time Complexity: O(A + B), where A is the number of nodes in A, and B the num of nodes in B
// Space Complexity: O(1)

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA == null || headB == null)
            return null;
        
        ListNode tailA = headA;
        ListNode tailB = headB;
        
        Pair<Integer, ListNode> sizeAndTailA = getListSize(tailA);
        Pair<Integer, ListNode> sizeAndTailB = getListSize(tailB);
        
        if(sizeAndTailA.getValue() != sizeAndTailB.getValue()) // lists don't match
            return null;
        
        int sizeA = sizeAndTailA.getKey();
        int sizeB = sizeAndTailB.getKey();
        
        int difference = Math.abs(sizeA - sizeB);
        ListNode longer = sizeA > sizeB ? headA : headB;
        ListNode shorter = sizeA > sizeB ? headB : headA;
        
        // advance longer list head 'difference' positions
        while(difference > 0) {
            longer = longer.next;
            difference--;
        }
        
        // advance til nodes collide
        while(longer != shorter) {
            longer = longer.next;
            shorter = shorter.next;
        }
        
        return longer;
    }
    
    public Pair<Integer, ListNode> getListSize(ListNode node) {
    
        int size = 1;
        while(node.next != null) {
            node = node.next;
            size++;
        }
        
        return new Pair<>(size, node);
    }
}