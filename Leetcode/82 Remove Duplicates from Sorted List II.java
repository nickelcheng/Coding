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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode hh = new ListNode();
        hh.next = head;
        ListNode prev = hh;
        ListNode curr = head;
        while (curr != null) {
            if (isRepeated(curr)) {
                prev.next = getNext(curr);
                curr = prev.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return hh.next;
    }
    
    private boolean isRepeated(ListNode node) {
        if (node == null) return false;
        if (node.next == null) return false;
        return node.val == node.next.val;
    }
    
    private ListNode getNext(ListNode node) {
        while (node.next != null) {
            if (node.val != node.next.val) return node.next;
            node = node.next;
        }
        return null;
    }
}
