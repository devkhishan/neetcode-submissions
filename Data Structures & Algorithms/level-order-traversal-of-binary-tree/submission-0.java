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
        if (root == null) return ans;
        Queue<TreeNode> que = new LinkedList<>();
        Queue<TreeNode> temp = new LinkedList<>();
        List<Integer> sans = new ArrayList<>();
        que.add(root);
        ans.add(new ArrayList<>(List.of(root.val)));
        
        int ind = 0;
        while (!que.isEmpty()) {
            TreeNode curr = que.poll();
            if (curr.left != null) {
                temp.add(curr.left);
                sans.add(curr.left.val);
            }
            if (curr.right != null) {
                temp.add(curr.right);
                sans.add(curr.right.val);
            }

            if (que.isEmpty() && !temp.isEmpty()) {
                ans.add(sans);
                que = new LinkedList<>(temp);
                temp = new LinkedList<>();
                sans = new ArrayList<>();
            }
        }
        return ans;
    }
}
