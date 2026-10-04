class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> rottenPairs = new ArrayDeque<>();
        int rowSize = grid.length;
        int colSize = grid[0].length;
        int minutes = 0;
        int freshCount = 0;

        for(int i=0;i<rowSize;i++){
            for(int j=0;j<colSize;j++){
                if(grid[i][j] == 2){
                    rottenPairs.offer(new int[] {i,j});
                } else if(grid[i][j] == 1){
                    freshCount++;
                }
            }
        }

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        while(! rottenPairs.isEmpty() && freshCount > 0){
            minutes++;
            int rotPairSize = rottenPairs.size();

            for(int i=0;i<rotPairSize;i++){
                int [] rotPair = rottenPairs.poll();
                for(int j=0;j<directions.length;j++){
                    int cheRow = directions[j][0] + rotPair[0];
                    int cheCol = directions[j][1] + rotPair[1];
                    if(cheRow>=0 && cheCol>=0 && cheRow<rowSize && cheCol<colSize && grid[cheRow][cheCol] == 1){
                        grid[cheRow][cheCol] = 2;
                        rottenPairs.offer(new int[] {cheRow,cheCol});
                        freshCount--;
                    }
                }
            }
        }

        return freshCount == 0 ? minutes : -1;
    }
}
