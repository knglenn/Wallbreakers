class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        generateSubsets(ret, new ArrayList<>(), nums, 0);
        return ret;
    }
    
    public void generateSubsets(List<List<Integer>> ret, List<Integer> list, int[] nums, int start) {
        ret.add(new ArrayList<>(list));

        for(int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            generateSubsets(ret, list, nums, i + 1);
            list.remove(list.size() -1);
        }

    }
}