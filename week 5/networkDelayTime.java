class Solution {
    //NlogN runtime, where N is number of edges 
    //N + E space
    public int networkDelayTime(int[][] times, int N, int K) {
        
        HashMap<Integer, HashMap<Integer, Integer>> graph = new HashMap<>();
        for(int[] row : times) {
            graph.putIfAbsent(row[0] -1, new HashMap<Integer, Integer>());
            graph.get(row[0] -1).put(row[1] -1, row[2]);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        //node, distance
        pq.offer(new int[] {K -1, 0});
        
        boolean[] visited = new boolean[N];
        int totalTime = 0; 
        while(!pq.isEmpty()) {
            int[] temp = pq.poll();
            int node = temp[0]; 
            int distance = temp[1];
            if (visited[node]) {
                continue; 
            }
            visited[node] = true; 
            //update number of nodes remaining
            N--;
            totalTime = distance; 
            if(graph.containsKey(node)) {
                for(Map.Entry<Integer, Integer> e: graph.get(node).entrySet()) {
                    pq.offer(new int[] {e.getKey(), distance + e.getValue()});
                }
            }
        }
        return N != 0 ? -1 : totalTime; 
    }
}