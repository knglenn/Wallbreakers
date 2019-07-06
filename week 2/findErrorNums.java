class Solution {
    public int[] findErrorNums(int[] nums) {
        int sum = 0; 
        for(int i = 1; i <= nums.length; i++) {
            sum+=i; 
        }
        HashSet<Integer> set = new HashSet<>();
        int repeated = 0;
        int missing = 0; 
        int givenSum = 0; 
        for(int i = 0; i < nums.length; i++) {
            if(!set.add(nums[i])) {
                repeated = nums[i];
            }
            givenSum+=nums[i];
        }
        missing = sum - (givenSum - repeated);
        
        return new int[] {repeated, missing};
    }
}