class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxarea = 0;
        for(int r = 0; r < m ;r++){
            for(int c =0; c < n;c++){
                if(matrix[r][c] == 1 && r > 0){
                    matrix[r][c] += matrix[r-1][c];
                }
            }
            int[] heights = matrix[r];
           heights =  Arrays.stream(heights)
                              .boxed() // Converts int to Integer
                              .sorted(Comparator.reverseOrder()) // Sorts in reverse
                              .mapToInt(Integer::intValue) // Converts Integer back to int
                              .toArray(); // Returns a new int[] array;

            for(int i=0;i<n;i++){
                int base = i+1;
                int height = heights[i];

                maxarea = Math.max(maxarea,base*height);
            }
        }
        return maxarea;
    }
}