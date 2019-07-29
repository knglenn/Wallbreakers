class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        for(int i = 0; i < graph.length; i++) {
            //check if node has been visited first before calling dfs
            if(colors[i] == 0 && !dfs(graph, i, colors, 1)) {
                return false;
            }
        }
        return true; 
    }
    
    public boolean dfs(int[][] graph, int node, int[] colors, int color) {
        if(colors[node] != 0) {
            return colors[node] == color;
        }
        colors[node] = color; 
        for(int i = 0; i < graph[node].length; i++) {
                if(!dfs(graph, graph[node][i], colors, -color)) {
                    return false;
                }
        }
        return true; 

    }
}