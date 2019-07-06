class MyHashMap {
        int[] vals = new int[1000];
        int[] keys = new int[1000];
        boolean[] used = new boolean[1000];
        
        int entries = 0;
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        
    }
    public void resize() {
        int[] newV = new int[vals.length * 2];
        boolean[] newU = new boolean[vals.length * 2];
        int[] newK = new int[vals.length * 2];
        for(int i = 0; i < vals.length; i++) {
            newV[i] = vals[i];
            newU[i] = used[i];
            newK[i] = keys[i];
        }
        vals = newV;
        used = newU;
        keys = newK;
    }
    
    public int findHash(int key) {
        int hash = -1; 
        for(int i = 0; i < keys.length; i++) {
            if(keys[i] == key) {
                hash = i;
                break;
            }
        }
        return hash;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = key % vals.length;
        if(get(key) != -1) {
            if(keys[hash] != key) {
                hash = findHash(key);
            }
            vals[hash] = value;
        }
        else {
            while(used[hash]) {
                //collision handling
                Random rand = new Random();
                hash = (key + rand.nextInt(vals.length)) % vals.length;
            }
            vals[hash] = value;
            keys[hash] = key; 
            used[hash] = true;
            entries++;
            if(entries == vals.length) {
                resize();
            }
        }
        
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = key % vals.length; 
        if(keys[hash] == key) {
            return vals[hash];
        }
        //could have been a collision earlier causing hash to be recalculated
        hash = findHash(key);
      
        return hash == -1 ? hash : vals[hash];
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = key % vals.length; 
        if(keys[hash] != key) {
            hash = findHash(key);
        }
        if(hash!= -1 && keys[hash] == key) {
            vals[hash] = -1;
            keys[hash] = -1;
            used[hash] = false; 
            entries--;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */