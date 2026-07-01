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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> levelOrder = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if (root!=null) que.add(root);
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            if (node != null) {
                levelOrder.add(String.valueOf(node.val));
                que.add(node.left);
                que.add(node.right);
            } else {
                levelOrder.add("null");
            }
        }
        System.out.println(String.join(",", levelOrder));
        return String.join(",", levelOrder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] serials = data.split(",");
        int n = serials.length;
        TreeNode root = null;
        Queue<TreeNode> que = new LinkedList<>();
        if (n != 0) {
            root = new TreeNode(Integer.parseInt(serials[0]));
            que.add(root);
        }
        int ind = 1;

        while(!que.isEmpty()) {
            TreeNode curr = que.poll();
            if (ind >= n) break;
        
            curr.left = (serials[ind++].equals("null")) ? null : new TreeNode(Integer.parseInt(serials[ind-1]));
            curr.right = (serials[ind++].equals("null")) ? null : new TreeNode(Integer.parseInt(serials[ind-1]));
            if(curr.left != null) que.add(curr.left);
            if(curr.right != null) que.add(curr.right);
        }

        return root;
    }
}
