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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        Queue<TreeNode> que = new LinkedList<>();
        if (root!=null) que.add(root);

        while(!que.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            for(int i=que.size(); i>0; i--) {
                TreeNode node = que.poll();
                level.add(node.val);
                if (node.left != null) que.add(node.left);
                if (node.right != null) que.add(node.right);
            }

            ans.add(level);
        }
        return ans;
    }
}
