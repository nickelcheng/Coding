/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfs(root).getKey();
    }
    
    private Pair<Boolean, Integer> dfs(TreeNode node) {
        if (node == null) return new Pair<>(true, 0);
        Pair<Boolean, Integer> left = dfs(node.left);
        Pair<Boolean, Integer> right = dfs(node.right);
        int lH = left.getValue();
        int rH = right.getValue();
        boolean balanced = left.getKey() && right.getKey() && (Math.abs(lH - rH) <= 1);
        int height = Math.max(lH, rH) + 1;
        return new Pair<>(balanced, height);
    }
}
