class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        
        generatePerms(ret, new ArrayList<>(), nums);
        return ret; 
        
    }
    
    public void generatePerms(List<List<Integer>> ret, List<Integer> list, int[] nums) {
        if(list.size() == nums.length) {
            ret.add(new ArrayList<>(list));
        }
        else {
            for(int i = 0; i< nums.length; i++) {
                if(!list.contains(nums[i])) {
                    list.add(nums[i]);
                    generatePerms(ret, list, nums); 
                    list.remove(list.size() -1);
                }
            }
        }
        
    }
}