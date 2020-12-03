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
    private TreeNode newRoot;
    private TreeNode curr;
    
    public TreeNode increasingBST(TreeNode root) {
        newRoot = null;
        dfs(root);
        return newRoot;
    }
    
    private void dfs(TreeNode node) {
        if (node == null) return;
        
        dfs(node.left);
        if (newRoot == null) {
            newRoot = node;
            curr = newRoot;
        } else {
            curr.right = node;
            curr = node;
        }
        node.left = null;
        dfs(node.right);
    }
}
