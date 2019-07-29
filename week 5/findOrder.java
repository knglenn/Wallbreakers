class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for(int[] row : prerequisites) {
            graph.get(row[1]).add(row[0]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] dp = new boolean[numCourses];
        Stack<Integer> s = new Stack();
        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i, graph, dp, visited, s)) {
                return new int[] {};
            }
        }
        int[] ret = new int[numCourses];
        for(int i = 0; i < numCourses;i++) {
            ret[i] = s.pop();
        }
        return ret; 
    }
    
    public boolean dfs(int course, ArrayList<ArrayList<Integer>> graph, boolean[] dp, boolean[] visited, Stack<Integer> s) {
        if(visited[course]) {
            return dp[course];
        }
        visited[course] = true; 
        for(int i = 0; i < graph.get(course).size(); i++) {
            if(!dfs(graph.get(course).get(i), graph, dp, visited, s)) {
                dp[course] = false; 
                return false; 
            }
        }
        dp[course] = true;
        s.push(course);
        return true; 
    }
}