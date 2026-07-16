/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Integer, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node root = new Node(node.val);
        map.put(root.val, root);
        for(Node neighbor : node.neighbors) {
            if (map.containsKey(neighbor.val)) root.neighbors.add(map.get(neighbor.val));
            else root.neighbors.add(cloneGraph(neighbor));
        }
        return root;
    }
}