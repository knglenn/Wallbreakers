class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0; 
        int max = Integer.MIN_VALUE; 
        for(int num : nums) {
            sum+=num;
            max = Math.max(num, max);
            
        }
        int partitionSum = sum /k; 
        if(sum % k != 0 || max > partitionSum) {
            return false; 
        }
        
        return helper(nums, k, partitionSum, 0, 0, new boolean[nums.length]);
        
    }
    
    public boolean helper(int[] nums, int k, int partitionSum, int currentSum, int start, boolean[] visited) {
        //all subsets summed
        if(k == 0) {
            return true; 
        }
        if(currentSum > partitionSum) {
            return false; 
        }
        else if(currentSum == partitionSum) {
            //move on to next subset, reset currentsum
            return helper(nums, k-1, partitionSum ,0, 0, visited); 
        }
        for(int i = start; i < nums.length; i++ ){
            if(!visited[i]) {
                visited[i] = true; 
                if(helper(nums, k, partitionSum, currentSum + nums[i], i + 1, visited)) {
                    return true; 
                }
                //not required in sum, return visited to false
                visited[i] = false; 
            }
        }
        return false; 
    }
}