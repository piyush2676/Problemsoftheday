class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> a = new ArrayList<>();
        List<int[]> b = new ArrayList<>();

        for(int i = 0; i<n;  ++i){
            for(int j = 0 ; j < n ; j++){
                if(img1[i][j] == 1) a.add(new int[]{i,j});
                if(img2[i][j] == 1) b.add(new int[]{i,j});
            }
        }
        int[][] cnt = new int[2*n][2*n];
        int max = 0;
        for(int[] c : a){
            for(int[] d : b){
                int dx = d[0] - c[0] + n;
                int dy = d[1] - c[1] + n;
                max = Math.max(max,++cnt[dx][dy]);
            }
        }
        return max;
    }
}