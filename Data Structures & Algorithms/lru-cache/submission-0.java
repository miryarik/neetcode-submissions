class LRUCache {
    Node least;
    Node most;
    int capacity;
    HashMap<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        least = new Node(0, 0);
        most = new Node(0, 0);

        most.next = least;
        least.prev = most;
    }

    public int get(int key) {
        // check if key exists
        // if not return -1
        if (!cache.containsKey(key)) return -1;

        // if it does exist
        // fetch the value
        // move to most
        Node node = cache.get(key);
        removeNode(node);
        insertNode(node);
        return node.val;
    }

    public void put(int key, int value) {
        // check if we have it in cache
        // then update
        // and move new to most
        if (cache.containsKey(key)) {
            var node = cache.get(key);
            removeNode(node);
            insertNode(node);
            node.val = value;
        }

        // if not, then check if cache has space
        // then put
        // next to most
        else if (cache.size() < capacity) {
            var node = new Node(key, value);
            insertNode(node);
            cache.put(key, node);
        }

        // if not, then remove the one at least
        // put new next to most
        else {
            var lru = least.prev;
            removeNode(lru);
            cache.remove(lru.key);

            var node = new Node(key, value);
            insertNode(node);
            cache.put(key, node);
        }
    }

    private void removeNode(Node node) {
        var prev = node.prev;
        var next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insertNode(Node node) {
        var old = most.next;
        node.prev = most;
        node.next = old;
        old.prev = node;
        most.next = node;
    }

    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;

            next = null;
            prev = null;
        }
    }
}

