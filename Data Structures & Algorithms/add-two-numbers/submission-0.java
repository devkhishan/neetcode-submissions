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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c = 0;
        ListNode temp = l1;
        while (l1!=null || l2!=null) {
            int x = l1.val + l2.val + c;
            l1.val = x % 10;
            c = x / 10;

            if (l1.next == null && l2.next != null) {
                l1.next = new ListNode(0);
            } else if (l2.next == null && l1.next !=null) {
                l2.next = new ListNode(0);
            } else if (l1.next == null && l2.next == null && c!=0) {
                l1.next = new ListNode(c);
                break;
            }


            l1 = l1.next;
            l2 = l2.next;
        }

        return temp;

    }
}
