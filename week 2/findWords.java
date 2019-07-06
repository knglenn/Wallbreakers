class Solution {
    ArrayList<String> list = new ArrayList();
    
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String s : words) {
            trie.insert(s);
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                dfs(board, i, j, trie.node);
            }
        }
        
        return list; 
    }
    
    public void dfs(char[][] board, int i, int j, Trie.TrieNode node) {
        char temp = board[i][j];
        if(temp == 'X' || node.children[temp - 'a'] == null) {
            return;
        }
        node = node.children[temp - 'a'];
        if(node.fullWord != null) {
            list.add(node.fullWord);
            node.fullWord = null; 
        }
        
        board[i][j] = 'X';
        if(i > 0) {
            dfs(board, i -1, j, node);
        }
        if(i < board.length -1){
            dfs(board, i+ 1, j, node);
        }
        if(j > 0) {
            dfs(board, i, j -1, node);
        }
        if(j < board[i].length -1) {
            dfs(board, i, j + 1, node);
        }
        board[i][j] = temp; 
        
    }
    class Trie {
        TrieNode node = new TrieNode();
        public class TrieNode {
            String fullWord; 
            TrieNode[] children = new TrieNode[26];
            TrieNode() {
                fullWord = null; 
                for(int i = 0; i < children.length; i++) {
                    children[i] =null; 
                }
            }
        }
        
        private void insert(String word) {
            TrieNode current = node; 
            for(int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if(current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
            }
            current.fullWord = word; 
        }
        
    }
}