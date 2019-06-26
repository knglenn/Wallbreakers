class Solution {
    int[] parents;
    int count;
    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0) {
            return 0;
        }
        int cols = M[0].length;
        count = M.length;
        parents = new int[count];
        for(int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        for(int i = 0; i < M.length; i++) {
            for(int j = i+1; j < cols; j++) {
                if(M[i][j] == 1)
                 union(i, j);
            }
        }
        return count;
    }
    
    public int find(int i) {
        while(parents[i] != i) {
            parents[i] = parents[parents[i]];
            i = parents[i];
        }
        return i;
    }
    
    public void union(int x, int y) {
        int xGroup = find(x);
        int yGroup = find(y);
        if(xGroup!=yGroup) {
            parents[xGroup] = yGroup;
            count--;
        }
        
    }
}