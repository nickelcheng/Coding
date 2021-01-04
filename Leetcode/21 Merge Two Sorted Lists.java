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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        ListNode curr = new ListNode();
        ListNode head = curr;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    curr.val = l1.val;
                    l1 = l1.next;
                } else {
                    curr.val = l2.val;
                    l2 = l2.next;
                }
            } else {
                if (l1 != null) {
                    curr.val = l1.val;
                    l1 = l1.next;
                    if (l1 == null) break;
                } else {
                    curr.val = l2.val;
                    l2 = l2.next;
                    if (l2 == null) break;
                }
            }
            curr.next = new ListNode();
            curr = curr.next;
        }
        return head;
    }
}
