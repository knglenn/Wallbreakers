class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        generateCombos(ret, new ArrayList<>(), n, k, 1);
        return ret; 
    }
    public void generateCombos(List<List<Integer>> ret, List<Integer> list, int n, int k, int start) {
        if(list.size() == k) {
            ret.add(new ArrayList<>(list));
        }
        else {
            for(int i = start; i <= n; i++) {
                list.add(i);
                generateCombos(ret, list, n, k, i + 1);
                list.remove(list.size() -1);
            }
        }
    }
}