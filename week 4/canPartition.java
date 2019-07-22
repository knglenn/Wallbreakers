class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0; 
        int max = Integer.MIN_VALUE; 
        for(int num : nums) {
            sum+= num;
            max = Math.max(num, max);
        }
        if(sum %2 != 0 || max > sum /2) {
            return false; 
        }
        Boolean[][] memo = new Boolean[nums.length][(sum/2) + 1];
        return helper(nums, sum /2, memo, 0);
    }
    
    public boolean helper(int[] nums, int target, Boolean[][] memo, int i) {
        if(target == 0) {
            return true;
        }
        if(i == nums.length || target < 0) {
            return false;
        }
        if(memo[i][target] != null) {
            return memo[i][target];
        }
        if(helper(nums, target - nums[i], memo, i + 1) || helper(nums, target, memo, i + 1)) {
            return true;
        }
        memo[i][target] = false;
        return false; 
    }
    
}