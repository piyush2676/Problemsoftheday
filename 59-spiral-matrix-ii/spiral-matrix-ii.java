class Solution {
    public int[][] generateMatrix(int n) {
       if(n==0) return new int[][]{};
       int m = n;
       int[][] matrix = new int[m][n];
       int top = 0;
       int down = m-1;
       int left = 0;
       int right = n-1;
       int dir = 0; 
       int numbers = 1;
       while(top <= down && left <= right){
        if(dir == 0){ for(int i=left;i<=right;i++){
            matrix[top][i] = numbers++;
        }
        top++;
        }
        if(dir == 1){
            for(int i=top;i<=down;i++){
                matrix[i][right] = numbers++;
            }
            right--;
        }
        if(dir == 2){
            for(int i = right;i>=left;i--){
                matrix[down][i] =numbers++;
            }
            down--;
        }
        if(dir == 3){
            for(int i=down;i>=top;i--){
                matrix[i][left] = numbers++;
            }
            left++;
        }
        dir = (dir+1) % 4;
       }
       return matrix;
    }
}