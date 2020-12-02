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
    private final int length;
    private final Random rand;
    
    private ListNode curr;
    private ListNode head;

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        int len;
        this.curr = head;
        this.head = head;
        for (len = 0; head != null; len++, head = head.next);
        length = len;
        rand = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int steps = rand.nextInt(length);
        while(steps-- > 0) {
            curr = curr.next;
            if (curr == null) curr = head;
        }
        return curr.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
