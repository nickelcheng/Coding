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
    public ListNode swapPairs(ListNode head) {
        if (head == null) return head;
        if (head.next == null) return head;
        
        ListNode tmp = new ListNode(0);
        ListNode prev = tmp;
        ListNode curr = head;
        ListNode next = curr.next;
        
        while (next != null) {
            curr.next = next.next;
            next.next = curr;
            prev.next = next;
            prev = curr;
            curr = curr.next;
            if (curr == null) break;
            next = curr.next;
        }
        
        return tmp.next;
    }
}
