class Solution {
    public void rotate(int[] nums, int k) {
        Queue<Integer> q = new LinkedList<>();
        if(k > nums.length) {
           k = k % nums.length; 
        }
        for(int i = nums.length - k; i < nums.length; i++) {
            q.add(nums[i]);
        }
        for(int i = 0; i < nums.length - k; i++) {
            q.add(nums[i]);
        }
        for(int i = 0; i < nums.length; i++) {
            nums[i] = q.remove();
        }
        
    }
}