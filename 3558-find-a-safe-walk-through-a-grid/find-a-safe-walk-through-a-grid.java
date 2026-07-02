class Solution {
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] result = new int[m][n];
        for(int[] row : result){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        Deque<int[]> dq = new ArrayDeque<>();
        result[0][0] = grid.get(0).get(0);
        dq.offerFirst(new int[]{0,0});

        while(!dq.isEmpty()){
            int[] cell = dq.pollFirst();
            int r = cell[0];
            int c = cell[1];

            for(int[] dir : directions){
               int newr = r + dir[0];
               int newc = c + dir[1];

               if(newr < 0 || newr >= m || newc < 0 || newc >=n) continue;
               if(result[r][c] + grid.get(newr).get(newc) < result[newr][newc]){
                result[newr][newc] = result[r][c] + grid.get(newr).get(newc);
                if(grid.get(newr).get(newc) == 0){
                    dq.offerFirst(new int[] {newr,newc});
                }else{
                    dq.offerLast(new int[] {newr,newc});
                }
               }
            }
        }
        return health - result[m-1][n-1] >= 1;
    }
}