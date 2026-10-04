class Solution {
    int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int orangesRotting(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshNumber = 0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                } else if(grid[i][j] == 1) freshNumber++;
            }
        }

        int time = 0;
        while(freshNumber > 0 && !queue.isEmpty()){
            int levelSize = queue.size();
            for(int i=0; i<levelSize; i++){
                int[] current = queue.poll();

                for(int[] dir: directions){
                    int newRow = current[0] + dir[0];
                    int newCol = current[1] + dir[1];
                    if(newRow < 0 || newCol < 0 || newRow >= r || newCol >= c || grid[newRow][newCol] != 1) continue;
                    grid[newRow][newCol] = 2;
                    freshNumber--;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
            time++;
        }

        if(freshNumber > 0) return -1;
        return time;
    }
}
