class Solution {
    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int per = 0;
        for(int i=0; i< row; i++){
            for(int j=0; j< col; j++){
              ///check for boundary conditions only.
              ///need not to think for graph in first iteration
                if(grid[i][j] == 0) continue;
                //upar ka condition
                if(i==0 || grid[i-1][j] == 0) per++;
                //neche ka
                if(i== row-1 || grid[i+1][j] == 0) per++;
                //left side ka
                if(j==0 || grid[i][j-1] == 0) per++;
                //right ka
                if(j== col-1 || grid[i][j+1]==0) per++;

            }
        }

        return per;

        
    }
}