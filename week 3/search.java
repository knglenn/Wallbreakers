class Solution {
    public int search(int[] nums, int target) {
        int lo = 0; 
        int hi = nums.length -1; 
        
        while(hi >= lo ) {
            int middle = (hi + lo) / 2;
            
            if(target > nums[middle]) {
                lo = middle + 1; 
            }
            else if(target < nums[middle]) {
                hi = middle -1; 
            }
            else {
                return middle;
            }
        }
        return -1; 
    }
}