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
        if (head == null) return null;
        Node temp = head;
        Node res = new Node(-1);
        Node rm = res;

        Map<Node,Integer> indices = new HashMap<>();
        int ind = 0;

        List<Node> results = new ArrayList<>();
        while (temp != null) {
            rm.next = new Node(temp.val);
            rm = rm.next;
            results.add(rm);
            indices.put(temp, ind++);
            temp = temp.next;
        }

        temp = head;
        rm = res.next;

        while (temp != null) {
            if (temp.random == null) {
                rm.random = null;
            } else {
                ind = indices.get(temp.random);
                rm.random = results.get(ind);
            }
            temp = temp.next;
            rm = rm.next;
        }

        return res.next;
    }
}
