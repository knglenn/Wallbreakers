class Solution {
    
    public int dp[][];
    
    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()][word2.length()];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return helper(word1.length(), word2.length(),word1, word2);
    }
    
    public int helper(int i, int j, String word1, String word2) {
        if(i == 0) {
            return j;
        }
        if(j == 0) {
            return i; 
        }
        if(dp[i-1][j-1] != -1) {
            return dp[i-1][j-1];
        }
        int min; 
        if(word1.charAt(i-1) != word2.charAt(j -1)) {
            min = 1 + Math.min(helper(i -1, j, word1, word2), Math.min(helper(i, j-1, word1, word2), helper(i -1, j-1, word1, word2)));
        } 
        else {
            min = helper(i -1, j-1, word1, word2);
        }
        dp[i-1][j-1] = min; 
        return min; 
       
    }
}