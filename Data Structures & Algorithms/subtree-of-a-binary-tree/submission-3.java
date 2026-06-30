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
    boolean res = false;
    TreeNode sub;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null || q==null) return p==q;
        if (p.val != q.val) return false;
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);
        return left && right;
    }
    public void dfs(TreeNode root) {
        if (res || root==null) {
            if (sub == null) res = true;
            return;
        }
        res=isSameTree(root, sub);
        dfs(root.left);
        dfs(root.right);
    
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        this.sub = subRoot;
        dfs(root);
        return res;
    }
}
