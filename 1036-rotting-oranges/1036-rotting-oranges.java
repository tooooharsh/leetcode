class Solution {
    public int orangesRotting(int[][] grid) {

        if (grid == null || grid.length == 0) return -1;

        int rows = grid.length;
        int cols = grid[0].length;
   

        //DFS USE-> 1 queue and 1 arraylist
        Queue<int[]> queue = new LinkedList<>();


        int output = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                //couting rotten oranges and keeping them in queue for BFS
                if (grid[r][c] == 2) {
                    queue.add(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    //counting fresh oranges
                    output++; 
                }
            }
        }

        if (output == 0) return 0;

        int minutes = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean flag = false;

            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                int x = point[0];
                int y = point[1];

                for (int[] direction : directions) {
                    int newX = x + direction[0];
                    int newY = y + direction[1];

                    if (newX >= 0 && newX < rows && newY >= 0 
                    && newY < cols && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        queue.add(new int[]{newX, newY});
                        output--;
                        flag = true;
                    }
                }
            }

            if (flag) {
                minutes++;
            }
        }

        return output == 0 ? minutes : -1;
        
    }
}