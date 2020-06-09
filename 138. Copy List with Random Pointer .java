/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    
    HashMap<Node, Node> mapNodeToCopy = new HashMap<>();
    
    public Node copyRandomList(Node head) {
        
        if(head == null)
            return null;
        
        Node current = head;
        while(current != null) {
            Node copy = new Node(current.val);
            mapNodeToCopy.put(current, copy);
            current = current.next;
        }
        
        current = head;
        while(current != null) {
            Node copyCurrent = mapNodeToCopy.get(current);
            copyCurrent.next = mapNodeToCopy.get(current.next);
            copyCurrent.random = mapNodeToCopy.get(current.random);
            current = current.next;
        }
        
        return mapNodeToCopy.get(head);

    }
}