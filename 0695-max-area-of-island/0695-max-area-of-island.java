class Solution {
    public int maxAreaOfIsland(int[][] grid) {
         int m = grid.length;
        int n = grid[0].length;
        //int op = 0;
        int max_area = 0;
        

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int t = dfs(grid, i, j);
                    max_area = Math.max(max_area, t); 
                }
            }
        }

        return max_area;
        
    }

    private int dfs(int[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;

        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] != 1) {
            return 0;
        }

        //why 2? because visited hai

        grid[row][col] = 2;
        int area = 1;

        area += dfs(grid, row - 1, col);
        area += dfs(grid, row + 1, col);
        area += dfs(grid, row, col - 1);
        area += dfs(grid, row, col + 1);
        return area ;
    }

        
    
}