class Solution {
    public boolean exist(char[][] board, String word) {
        char[] wordArr = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(helper(board, wordArr,i, j, 0)) {
                    return true; 
                }
            }
        }
        return false; 
    }
    public boolean helper(char[][] board, char[] c, int i, int j, int currentIndex) {
        if(currentIndex == c.length) {
            return true; 
        }
        if(i < 0 || i >= board.length || j < 0 || j>=board[0].length || board[i][j] != c[currentIndex]) {
            return false; 
        }
        char current = c[currentIndex];
        //no need for visited array, change character and reset at end of recursion call
        board[i][j] = '*'; 
        boolean result = helper(board, c, i-1, j, currentIndex + 1) || helper(board, c, i + 1, j, currentIndex + 1) || helper(board, c, i, j-1, currentIndex + 1) || helper(board, c, i, j + 1, currentIndex + 1);
        board[i][j] = current;
        
        return result; 
    }
}