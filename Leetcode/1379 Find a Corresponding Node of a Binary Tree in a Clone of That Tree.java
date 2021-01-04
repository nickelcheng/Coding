/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return find(cloned, target.val);
    }
    
    private TreeNode find(TreeNode node, int val) {
        if (node == null) return null;
        if (node.val == val) return node;
        TreeNode left = find(node.left, val);
        if (left != null) return left;
        TreeNode right = find(node.right, val);
        if (right != null) return right;
        return null;
    }
}
