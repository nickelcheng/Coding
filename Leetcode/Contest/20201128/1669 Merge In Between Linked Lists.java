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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode aNode = list1;
        for (int i = 0; i < a-1; i++) {
            aNode = aNode.next;
        }
        ListNode bNode = list1;
        for (int i = 0; i < b; i++) {
            bNode = bNode.next;
        }
        aNode.next = list2;
        ListNode lastNode2 = list2;
        while (lastNode2.next != null) {
            lastNode2 = lastNode2.next;
        }
        lastNode2.next = bNode.next;
        return list1;
    }
}
