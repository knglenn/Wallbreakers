class Solution {
    int[][] dp; 
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0]; 
        }
        dp = new int[2][nums.length];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return Math.max(helper(0,0,nums),helper(1, 1, nums));
    }
    public int helper(int first, int last, int nums[]) {
        if(last == nums.length -1) {
            if(first == 0 ) {
                return nums[0] >= nums[nums.length -1] ? 0 : nums[nums.length -1] - nums[0];
            }
            else{
                return nums[nums.length -1];
            }
            
        }
        else if(last >=nums.length) {
            return 0; 
        }
        
        if(dp[first][last] != -1) {
            return dp[first][last];
        }
        int ret = Math.max(nums[last] + helper(first, last + 2, nums), helper(first, last + 1, nums)); 
        dp[first][last] = ret; 
        return ret; 
       
        
    }
}