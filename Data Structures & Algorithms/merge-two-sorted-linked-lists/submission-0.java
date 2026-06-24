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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // if (list1 == null) return list2;
        // if (list2 == null) return list1;
        
        ListNode ans = new ListNode();
        ListNode mover = ans;

        while (list1!=null && list2!=null) {
            if (list2.val <= list1.val) {
                System.out.println("List2 val is lesser :" + list2.val);
                mover.next = list2;
                list2 = list2.next;
            } else {
                System.out.println("List1 val is lesser :" + list1.val);
                mover.next = list1;
                list1 = list1.next;
            }
            mover = mover.next;
        }
        if (list1!=null) mover.next = list1;
        if (list2!=null) mover.next = list2;
        return ans.next;
    }
}