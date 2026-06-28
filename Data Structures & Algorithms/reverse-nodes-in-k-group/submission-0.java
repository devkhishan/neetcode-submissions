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
    public ListNode[] reverse(ListNode curr, int k) {
        ListNode prev = null;

        while (k>0) {
            ListNode next = curr.next; 
            curr.next = prev; 
            prev = curr; 
            curr = next;
            k--;
        }
        return new ListNode[]{curr,prev};
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        ListNode counter = head; 
        while (counter != null) {
            counter = counter.next;
            n++;
        }

        ListNode answer = new ListNode(-1, head);
        counter = answer;
        for(int i=-1;i<n-1;i++) {
            if ((i+1)%k==0 && (n-(i+1)>=k)) {
                ListNode[] rev = reverse(counter.next,k);
                counter.next.next = rev[0];
                counter.next = rev[1];
            }
            counter = counter.next;
        }

        return answer.next;
    }
}
