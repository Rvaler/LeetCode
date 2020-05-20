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
    
    // O(n*k), with standard approach
    // Using a min heap, we can improve to O(n*log k)
    
    // Time Complexity: O(n * log(k))
    // Space Complexity: O(k)
    
    class NodeComparator implements Comparator<ListNode> {
        public int compare(ListNode n1, ListNode n2) {
            return n1.val - n2.val;
        }
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<ListNode> minHeap = 
            new PriorityQueue<ListNode>(new NodeComparator());
        
        for(ListNode list: lists) {
            if(list != null)
                minHeap.add(list);
        }
        
        ListNode resultHead = null;
        ListNode resultTail = null;
        
        while(!minHeap.isEmpty()) {
            ListNode minNode = minHeap.remove();
            if(minNode.next != null)
                minHeap.add(minNode.next);
            
            if(resultHead == null) {
                resultHead = minNode;
                resultTail = minNode;
            } else {
                resultTail.next = minNode;
                resultTail = resultTail.next;
            }
        }
        
        if(resultTail != null)
            resultTail.next = null;
        
        return resultHead;
    }
}