class MyHashSet {
    int[] values = new int[10000];
    boolean[] used = new boolean[10000];
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        Arrays.fill(values, -1);
    }
    
    public int hash(int key) {
        return key % values.length; 
    }
    public void add(int key) {
        if(!contains(key)) {
            int hash = hash(key);
            while(used[hash]) {
                Random rand = new Random();
                hash = (hash + rand.nextInt(values.length)) % values.length;
            }
            values[hash] = key;
            used[hash] = true; 
        }
    }
    
    public void remove(int key) {
        int hash = hash(key);
        if(values[hash] != key) {
            boolean found = false;
            for(int i = 0; i < values.length; i++) {
                if(values[i] == key) {
                    hash = i; 
                    found = true; 
                    break;
                }
            }
            if(!found) {
                hash = -1; 
            }
        }
        if(hash != -1) {
            values[hash] = -1; 
            used[hash] = false;
        } 
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash = hash(key);
        if(values[hash] == key && used[hash]) {
            return true; 
        }
        for(int i : values) {
            if(i == key) {
                return true; 
            }
        }
        return false; 
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */