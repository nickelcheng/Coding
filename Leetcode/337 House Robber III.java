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
    class MyNode {
        int val;
        MyNode left;
        MyNode right;
        int takeMax;
        int noMax;
        MyNode() {
            takeMax = -1;
            noMax = -1;
        }
        MyNode(int val, MyNode left, MyNode right, int take, int no) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.takeMax = take;
            this.noMax = no;
        }
    }
    public int rob(TreeNode root) {
        if (root == null) return 0;
        
        MyNode myRoot = new MyNode();
        copyNode(root, myRoot);
        
        int take = dfs(myRoot, true);
        int no = dfs(myRoot, false);
        
        return Math.max(take, no);
    }
    
    private void copyNode(TreeNode tn, MyNode mn) {
        mn.val = tn.val;
        if (tn.left != null) {
            mn.left = new MyNode();
            copyNode(tn.left, mn.left);
        }
        if (tn.right != null) {
            mn.right = new MyNode();
            copyNode(tn.right, mn.right);
        }
    }
    
    private int dfs(MyNode node, boolean take) {
        if (node == null) return 0;
        
        int rightNo = dfs(node.right, false);
        int leftNo = dfs(node.left, false);
        
        if (take) {
            if (node.takeMax != -1) return node.takeMax;
            
            node.takeMax = node.val + rightNo + leftNo;
            return node.takeMax;
        }
        if (node.noMax != -1) return node.noMax;
        
        int rightTake = dfs(node.right, true);
        int leftTake = dfs(node.left, true);
        int right = Math.max(rightTake, rightNo);
        int left = Math.max(leftTake, leftNo);
        
        node.noMax = right + left;
        return node.noMax;
    }
    
}
// 9 min, sol1: WA

// 35 min, sol2: WA
// 44 min, sol2: WA (fix typo)
// 56 min, sol2: AC
