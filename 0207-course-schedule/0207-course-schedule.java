class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //we made an adjancency list 
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        ///graph build kara
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            graph[prerequisiteCourse].add(course);
        }
        
        // 0 = unvisited, 1 = visiting, 2 = visited
        int[] visited = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            if (dfs(graph, visited, i) == false) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<Integer>[] g, int[] v, int course) {
        if (v[course] == 1) {
            return false;
        }
        if (v[course] == 2) {
            return true;
        }
        
        v[course] = 1;
        
       
        for (int i : g[course]) {
            if (!dfs(g, v, i)) {
                return false;
            }
        }
        
      
        v[course] = 2;
        return true;
    }
        
    
}