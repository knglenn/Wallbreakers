class Solution {
    int[][] dp; 
    public boolean isMatch(String s, String p) {

        dp = new int[s.length() + 1][p.length() + 1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(0, 0, s, p);
        
    }
    
    public boolean helper(int i, int j, String s, String p) { 
        if(j == p.length()) {
            return i == s.length(); 
        }
        if(dp[i][j] != -1) {
            return dp[i][j] == 1 ? true : false; 
        }
        boolean result = false; 
        if(j < p.length() -1 && p.charAt(j + 1) == '*') {
            if(helper(i, j+2, s, p)) {
                return true; 
            }
            if(i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
                result = helper(i + 1, j, s, p);
            }
        }
        else {
            if(i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
                result = helper(i + 1, j + 1, s, p);
            }
        }
        dp[i][j] = result ? 1 : 0; 
        return result; 
    }
}