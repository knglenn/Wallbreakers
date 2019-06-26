class Solution {
    int[] parents; 
    int count = 0; 
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0; 
        }
        int cols = grid[0].length;
        //total number of elements in grid
        parents = new int[grid.length * cols];
        for(int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    if(i!=0 && grid[i-1][j] == '1') {
                        union(i* cols + j, (i-1) * cols + j);
                    }
                    if(j!=0 && grid[i][j-1] == '1') {
                        union(i * cols + j, i * cols + (j -1));
                    }
                }
            }
        }
        return count;
    }
    
    public int find(int i) {
        while(parents[i]!= i){
            i = parents[parents[i]];
        }
        return i;
    }
    
    public void union(int x, int y) {
        int xGroup = find(x);
        int yGroup = find(y);
        if(xGroup != yGroup) {
            parents[xGroup] = parents[yGroup]; 
            count--;
        }
    }
}