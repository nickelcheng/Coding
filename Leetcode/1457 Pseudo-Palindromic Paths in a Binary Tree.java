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
    public int pseudoPalindromicPaths (TreeNode root) {
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode node, int bitMask) {
        if (node == null) return 0;
        
        if (node.left == node.right) {
            return isValid(bitMask ^ (1 << node.val)) ? 1 : 0;
        }
        
        int newMask = bitMask ^ (1 << node.val);
        return dfs(node.left, newMask) + dfs(node.right, newMask);
    }
    
    private boolean isValid(int bitMask) {
        if (bitMask == 0) return true;
        int cnt = 0;
        for (int i = 1; i <= 9; i++) {
            if ((bitMask & (1 << i)) > 0) cnt++;
        }
        return cnt == 1;
    }
}
