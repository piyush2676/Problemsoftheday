class Solution {
    int m,n;
     int[][] directions = {{1,0},{-1,0},{0,-1},{0,1}};
    public boolean cycleDetectDfs(int r,int c,int prev_r,int prev_c,char[][] grid,boolean[][] vis){
        if(vis[r][c]){
            return true;
        }
        vis[r][c] = true;

        for(int[] dir : directions){
            int new_r = r+dir[0];
            int new_c = c+dir[1];

            if(new_r >=0 && new_r < m && new_c >=0 && new_c < n && grid[new_r][new_c] == grid[r][c]){
                if(new_r == prev_r && new_c == prev_c){
                    continue;
                }
                if(cycleDetectDfs(new_r,new_c,r,c,grid,vis)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && cycleDetectDfs(i,j,i,j,grid,vis)){
                    return true;
                }
            }
        }
        return false;
    }
}