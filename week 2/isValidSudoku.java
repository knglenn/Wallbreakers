class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            HashSet<Character> rowSet = new HashSet<>();
            HashSet<Character> colSet = new HashSet<>();
            HashSet<Character> boxSet = new HashSet<>();
            
            for(int j = 0; j < board.length; j++) {
                if(board[i][j] != '.' && !rowSet.add(board[i][j])) {
                    return false; 
                }
                if(board[j][i] != '.' && !colSet.add(board[j][i])) {
                    return false;
                }
                int rowB = (3 * (i /3)) + (j/3);
                int colB = (3 * (i % 3)) + (j % 3);
                
                if(board[rowB][colB] != '.' && !boxSet.add(board[rowB][colB])) {
                    return false; 
                }
            }
        }
        return true; 
    }
}