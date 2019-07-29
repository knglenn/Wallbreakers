class Solution {
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0; 
        }
        dp = new int[matrix.length][matrix[0].length];
        int pathLength = 0; 
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                pathLength = Math.max(pathLength, helper(i, j, matrix));
            }
        }
        return pathLength; 
    }
    
    public int helper(int i, int j, int[][] matrix) {
        if(dp[i][j] != 0) {
            return dp[i][j];
        }
        int max = 1; 
        
        if(i > 0 && matrix[i - 1][j] > matrix[i][j]) {
            max = Math.max(max, 1 + helper(i -1, j, matrix));
        }
        if(i < matrix.length-1 && matrix[i + 1][j] > matrix[i][j]) {
            max = Math.max(max, 1 + helper(i+1, j, matrix));
        }
        if(j > 0 && matrix[i][j -1] > matrix[i][j]) {
            max = Math.max(max, 1 + helper(i, j-1, matrix));
        }
        if(j < matrix[0].length -1 && matrix[i][j+1] > matrix[i][j]) {
            max = Math.max(max, 1 + helper(i, j+1, matrix));
        }
        dp[i][j] = max;
        return max; 
        
    }
}