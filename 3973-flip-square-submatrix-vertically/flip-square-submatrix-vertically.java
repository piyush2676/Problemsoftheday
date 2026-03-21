class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int l = x;
        int r = x+k-1;

        while(l<r){
            for(int col = y; col < y + k ;col++){
                int temp = grid[l][col];
                grid[l][col] = grid[r][col];
                grid[r][col] = temp;
            }
            l++;
            r--;
        }
        return grid;
    }
}