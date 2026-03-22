class Solution {
    int n;
    
    public void rotate(int[][] mat){
        n = mat.length;
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        for(int i=0;i<n;i++){
        int start = 0;
        int end = n-1;
        while(start<end){
            int temp = mat[i][start];
            mat[i][start] = mat[i][end];
            mat[i][end] = temp;

            start++;
            end--;
        }
        }
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        n = mat.length;
        
        for(int c=1;c<=4;c++){
            boolean isequal = true;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(mat[i][j] != target[i][j]){
                        isequal = false;
                         break;
                    }
                }
                if(!isequal)
                    break;

                
            }
            if(isequal) return true;
            rotate(mat);
        }
        return false;
    }
}