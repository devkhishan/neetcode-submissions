class LRUCache {

    int capacity;
    Node left, right;
    Map<Integer, Node> cache;
    class Node {
        int val, key;
        Node prev, next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        
        left = new Node(0,0);
        right = new Node(0,0);
        left.next = right;
        right.prev = left;
    }
    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void insert(Node node) {
        node.prev = right.prev;
        node.prev.next = node;
        node.next = right;
        right.prev = node;
    }
    public int get(int key) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
            insert(cache.get(key));
            return cache.get(key).val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        cache.put(key, new Node(key, value));
        insert(cache.get(key));

        if (cache.size() > capacity) {
            Node lru = left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}
