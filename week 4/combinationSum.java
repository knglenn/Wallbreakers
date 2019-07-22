class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        backtrack(ret, new ArrayList<>(), candidates, target, 0);
        return ret; 
    }
    
    public void backtrack(List<List<Integer>> ret, List<Integer> list, int[] candidates, int remaining, int current) {
        if(remaining < 0) {
            return;
        }
        else if(remaining == 0) {
            ret.add(new ArrayList<>(list));
        }
        else {
            for(int i = current; i < candidates.length; i++) {
                list.add(candidates[i]);
                backtrack(ret, list, candidates, remaining  - candidates[i], i);
                list.remove(list.size() -1);
            }
        }
    }
}