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
    int ans = Integer.MIN_VALUE; 
    public int dfs(TreeNode root) {
        if (root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);
        
        int ret = Math.max(
            Math.max(root.val + left, root.val + right), 
            root.val
        );
        ans = Math.max(ans, Math.max(ret,root.val + left + right));
        return ret;
    }
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }
}
