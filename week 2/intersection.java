class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int i : nums1) {
            set.add(i);
        }
        
        HashSet<Integer> intersection = new HashSet<>();
        for(int i : nums2) {
            if(set.contains(i)) {
                intersection.add(i);
            }
        }
        return intersection.stream().mapToInt(x->x).toArray();
    }
}