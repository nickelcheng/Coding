/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    private static class MyNode {
        private Node node;
        private int lv;
        MyNode(Node n, int l) {
            node = n;
            lv = l;
        }
    }
    private static class MyQueue {
        private Deque<MyNode> q;
        MyQueue() {
            q = new LinkedList<>();
        }
        void push(Node n, int l) {
            if (n == null) {
                return;
            }
            if (!q.isEmpty() && q.getLast().lv == l) {
                q.getLast().node.next = n;
            }
            q.add(new MyNode(n, l));
        }
        MyNode pop() {
            return q.remove();
        }
        boolean isEmpty() {
            return q.isEmpty();
        }
    }
    public Node connect(Node root) {
        MyQueue mq = new MyQueue();
        mq.push(root, 0);
        while(!mq.isEmpty()) {
            MyNode curr = mq.pop();
            mq.push(curr.node.left, curr.lv + 1);
            mq.push(curr.node.right, curr.lv + 1);
        }
        return root;
    }
}
