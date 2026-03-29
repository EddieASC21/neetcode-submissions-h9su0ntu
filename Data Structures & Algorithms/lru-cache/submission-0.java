public class Node{
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

public class LRUCache {

    private int cap;
    private HashMap<Integer, Node> cache;
    private Node lru;
    private Node mru;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        this.lru = this.mru = new Node(0, 0);
        this.lru.next = this.mru;
        this.mru.prev = this.lru;
    }
    
    public void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void add(Node node){
        Node prev = this.mru.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.mru;
        this.mru.prev = node;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            add(node);
            return node.val;
        }

        return -1;
    }
    
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
