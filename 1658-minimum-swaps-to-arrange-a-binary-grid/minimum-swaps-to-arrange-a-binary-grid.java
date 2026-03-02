class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] trailingzeroes = new int[n];
        int[] temp = new int[n];
        for(int i=0;i<n;i++){
            int j = n-1;
            int count = 0;
            while(j>=0 && grid[i][j] == 0){
                count++;
                j--;
            }
            trailingzeroes[i] = count;
        }
        int steps = 0;
        for(int i=0;i<n;i++){
            int needzeroes = n - i -1;
            int j = i;
            while( j<n && trailingzeroes[j] < needzeroes){
                j++;
            }
            if(j==n){
                return -1;
            }
             steps += j-i;

            while(j>i){
                temp[i] = trailingzeroes[j];
                trailingzeroes[j] = trailingzeroes[j-1];
                trailingzeroes[j-1] = temp[i];
                j--;
            }
        }
        return steps;
    }
}