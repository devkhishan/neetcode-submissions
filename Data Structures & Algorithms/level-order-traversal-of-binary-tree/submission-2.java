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
        que.add(root);

        while(!que.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            for(int i=que.size(); i>0; i--) {
                TreeNode node = que.poll();
                if (node != null) {
                    level.add(node.val);
                    que.add(node.left);
                    que.add(node.right);
                }
            }

            if (level.size() > 0) ans.add(level);
        }
        return ans;
    }
}
