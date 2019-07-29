class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       //create graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(numCourses);
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        for(int[] row : prerequisites) {
            graph.get(row[1]).add(row[0]);
            
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] dp = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i, graph, visited, dp)) {
                return false;
            }
        }
        return true; 
    }
    
    public boolean dfs(int course, ArrayList<ArrayList<Integer>> graph, boolean[] visited, boolean[] dp) {
       if(visited[course]) {
           return dp[course];
       }
        visited[course] = true; 
       for(int i = 0; i < graph.get(course).size(); i++) {
           if(!dfs(graph.get(course).get(i), graph, visited, dp)) {
               dp[course] = false;
               return false; 
           }
       }
        
        dp[course] = true; 
        return true; 
        
    }
}