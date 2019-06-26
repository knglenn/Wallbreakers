class Solution {
    int[] parents;
    public void solve(char[][] board) {
        if(board == null || board.length == 0) {
            return;
        }
        int rows = board.length; 
        int cols = board[0].length; 
        parents = new int[rows * cols + 1];
        for(int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        parents[rows * cols] = rows * cols;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(board[i][j] == 'O' && (i == 0 || j == 0 || i == rows -1 || j == cols -1)) {
                    union(i * cols + j, rows * cols);
                }
                else{
                    if(board[i][j] == 'O') {          
                        if(board[i+1][j] == 'O') {
                            union(i * cols + j, (i+1) * cols + j);
                        }
                        if(board[i-1][j] == 'O') {
                            union(i * cols + j, (i-1) * cols + j);
                        }
                        if(board[i][j-1] == 'O') {
                            union(i * cols + j, i * cols + (j-1));
                        }
                        if(board[i][j+1] == 'O') {
                            union(i * cols + j, i * cols + (j+1));
                        }
                    }
                }
            }
        }
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(find(rows * cols) != find(i * cols + j)) {
                    board[i][j] = 'X';
                }
                else {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    public int find(int i) {
        while(parents[i] != i) {
            i = parents[parents[i]];
        }
        return i;
    }
    
    public void union(int x, int y) {
        int xGroup = find(x);
        int yGroup = find(y);
        if(xGroup!=yGroup) {
            parents[xGroup] = yGroup;
        }
    }
}