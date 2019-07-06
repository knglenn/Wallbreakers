class Trie {
    TrieNode root = new TrieNode(); 
    /** Initialize your data structure here. */
    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean endOfWord;
          TrieNode() {
             endOfWord = false;
             for(int i = 0; i < children.length; i++) {
                 children[i] = null; 
             }
         }
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode current = root; 
        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.endOfWord = true; 
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode current = root; 
        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(current.children[index] == null) {
                return false; 
            }
            current = current.children[index];
        }
        return current!= null && current.endOfWord; 
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode current = root; 
        for(int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if(current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return current!= null; 
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */