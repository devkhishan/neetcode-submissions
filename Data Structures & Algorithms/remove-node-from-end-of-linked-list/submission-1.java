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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0, ind = 0;
        ListNode mover = head;
        while(mover != null) {
            mover = mover.next;
            len++;
        }

        if (n-len==0) return head.next;
        mover = head;
        while (mover != null) {
            if ((ind+1) == len-n) {
                mover.next = mover.next.next;
                break;
            }
            mover = mover.next;
            ind++;
        }
        
        return head;
    }
}
