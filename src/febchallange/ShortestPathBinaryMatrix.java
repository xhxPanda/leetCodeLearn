package febchallange;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
                
        // if the cell is already 1 then return -1
        if (grid[0][0] == 1) return - 1;
        //get the row and col length of the grid
        int row = grid.length;
        int col = grid[0].length;
        //call for bfs
        return bfs(grid, row, col);
    }
    
    private int bfs(int[][] grid, int row, int col){
        //8 directions
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1},{1,1},{1,-1},{-1,1}, {-1,-1}};
        
        // queue for shortest path
        Queue<int[]> q = new LinkedList<>();
        // offer the 0,0 cell with the length step count as 1
        q.offer(new int[]{0,0,1});
        // set the cell 0,0 as visited
        grid[0][0] = 1;
        
        //if not empty
        while (!q.isEmpty()){
            //get the size to track for the level completion
            int size = q.size();
            
            // loop until the size of the level
            for (int i = 0; i < size; i++){
                //get the cell values from the queue
                int[] cell = q.poll();
                int currX = cell[0];
                int currY = cell[1];
                int currStep = cell[2];
                
                //if the cell reaches the end then return the step count
                if (currX == row-1 && currY == col-1) return currStep;
                
                // go all 8 directions
                for (int[] dir : dirs){
                    // add the direction to the current x and current y
                    int x = currX + dir[0];
                    int y = currY + dir[1];
                    
                    //boundary checking and confirm if the grid is equal to 0
                    if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == 0){
                        //add to the queue
                        q.offer(new int[]{x, y, currStep+1});
                        //set the grid to visited
                        grid[x][y] = 1;
                    }
                }
            }
        }
        //if it could not be found return not possible
        return -1;
    }
}