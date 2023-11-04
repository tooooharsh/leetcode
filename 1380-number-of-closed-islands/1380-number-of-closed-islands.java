class Solution {

     private boolean dfsHelper(int[][] grid, int x, int y, int m, int n) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return false;
        }
        if (grid[x][y] == 1) {
            return true;
        }
        grid[x][y] = 1;
        boolean result = true;
        result &= dfsHelper(grid, x + 1, y, m, n);
        result &= dfsHelper(grid, x - 1, y, m, n);
        result &= dfsHelper(grid, x, y + 1, m, n);
        result &= dfsHelper(grid, x, y - 1, m, n);
        return result;
    }
    public int closedIsland(int[][] grid) {
         //null check
         if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        // len and breadth set
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //if cell = 0 ,check for island using helper function
                if (grid[i][j] == 0) {
                    if (dfsHelper(grid, i, j, m, n)) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

        
    
}