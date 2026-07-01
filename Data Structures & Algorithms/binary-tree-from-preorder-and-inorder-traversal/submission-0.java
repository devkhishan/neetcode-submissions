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
    int pre = 0, in = 0;
    int[] preo, ino;

    public TreeNode dfs(int limit) {
        if (pre >= preo.length) return null;
        if (ino[in] == limit) {
            in++;
            return null;
        }

        TreeNode root = new TreeNode(preo[pre++]);
        root.left = dfs(root.val);
        root.right = dfs(limit);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preo = preorder;
        ino = inorder;
        return dfs(Integer.MAX_VALUE);
    }
}
