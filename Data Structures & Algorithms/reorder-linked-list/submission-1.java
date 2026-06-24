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
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
    public void reorderList(ListNode head) {
        if (head.next==null || head.next.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        ListNode s_prev = null;
        ListNode ans = new ListNode();
        ListNode mover = ans;
        ListNode h1 = head;

        while (fast!=null && fast.next!=null) {
            s_prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        s_prev.next = null;

        ListNode h2 = reverse(slow);

        while (h1!=null) {
            mover.next = h1;
            h1 = h1.next;
            mover = mover.next;
            
            mover.next = h2;
            h2 = h2.next;
            mover = mover.next;
        }

        head = ans.next;
    }
}
