class LRUCache {

    // we create a node class that will hold the key, value, and pointers for the previous/next nodes
    public class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
            this.prev = this.next = null;
        }

    }

    private int cap;
    private HashMap<Integer, Node> cache;
    private Node lru;
    private Node mru;

    public LRUCache(int capacity) {
        // we now initialize our cache given the capacity that was passed
        this.cap = capacity;
        this.cache = new HashMap<>();
        // we now set up our lru and mru nodes that serve as our head and tail node as this will help with adding a node to the back and removing a node
        this.lru = this.mru = new Node(0, 0);
        this.lru.next = this.mru;
        this.mru.prev = this.lru;
    }

    // the manner in which removing nodes is done by detaching the node from the doubly linked list
    public void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    // the way in which adding nodes work is that a node is added right nefore our mru dummy node as this will help mark the node as the most recently used
    public void add(Node node){
        Node prev = this.mru.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.mru;
        this.mru.prev = node;
    }

    // if the key is found, we want to store node and then remove it as we will then add it back but to the back where its next node would be mru to show that the node is in the most recently used position
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            add(node);
            return node.val;
        }

        return -1;
    }

    // we check to see uf the key exists in the cache to remove it and then add it to the back of our list, this would be our way of updating the value if the key already exists
    // we would remove lru.next or the least recently used item from the list if the current size of our cache is greater than that of our given capacity
    public void put(int key, int value) {
        if(cache.containsKey(key)) remove(cache.get(key));

        Node node = new Node(key, value);
        cache.put(key, node);
        add(node);

        if(cache.size() > cap){
            Node currLru = this.lru.next;
            remove(currLru);
            cache.remove(currLru.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */