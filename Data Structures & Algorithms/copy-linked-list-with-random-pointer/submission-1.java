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
    public Node copyRandomList(Node head) {
        // Interleave nodes 
        Node curr = head;

        while (curr != null) {
            Node clone = new Node(curr.val);
            clone.next = curr.next;
            curr.next = clone;
            curr = curr.next.next;
        }

        // Set Random
        curr = head;

        while (curr != null) {
            Node clone = curr.next;
            if (curr.random != null) {
                clone.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        
        // Connect Next
        Node dummy = new Node(-1);
        Node tail = dummy;

        curr = head;

        while (curr != null) {
            tail.next = curr.next;
            curr.next = curr.next.next;
            tail = tail.next;
            curr = curr.next;
        }

        return dummy.next;
    }
}
