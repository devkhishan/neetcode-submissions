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
    public int dfs(TreeNode root, int macs) {
        if (root == null) return 0;
        int lmacs = Math.max(macs, root.val);
        int check = (root.val >= macs) ? 1 : 0;
        int left = dfs(root.left,lmacs);
        int right = dfs(root.right, lmacs);
        return left + right + check;
    }
    public int goodNodes(TreeNode root) {
        return dfs(root, -101);
    }
}
