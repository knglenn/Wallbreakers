class LRUCache {
    HashMap<Integer, DoublyLinkedNode> cache; 
    int capacity;
    DoublyLinkedNode head;
    DoublyLinkedNode tail; 
    public LRUCache(int capacity) {
        this.capacity = capacity; 
        cache = new HashMap<>();
        head = new DoublyLinkedNode(-1, -1);
        tail = new DoublyLinkedNode(-1, -1);
        head.next= tail;
        tail.prev = head; 
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
            int temp = cache.get(key).value;
            removeNode(key);
            addToHead(key, temp);
            return temp; 
        }   
        return -1; 
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            removeNode(key);
        }
        addToHead(key, value);
       
    }
    public void removeNode(int key) {
        DoublyLinkedNode temp = cache.get(key);
        cache.remove(key);
        DoublyLinkedNode prev = temp.prev; 
        DoublyLinkedNode next = temp.next;
        prev.next = next;
        next.prev = prev; 
    }
    
    public void addToHead(int key, int value) {
        DoublyLinkedNode temp = new DoublyLinkedNode(key, value);
        DoublyLinkedNode nextNode = head.next;
        temp.next = nextNode;
        temp.prev = head; 
        head.next = temp;
        nextNode.prev = temp; 
        cache.put(key, temp);
        if(cache.size() > capacity) {
            DoublyLinkedNode LRUNode = tail.prev; 
            removeNode(LRUNode.key);
        }
    }
    class DoublyLinkedNode {
        int value; 
        int key; 
        DoublyLinkedNode next;
        DoublyLinkedNode prev; 
        public DoublyLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */