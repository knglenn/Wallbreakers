class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
       
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
         PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((x, y) -> Integer.compare(x.getValue(), y.getValue()));
        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            pq.add(e);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            ret.add(pq.poll().getKey());
        }
        return ret; 
    }
}