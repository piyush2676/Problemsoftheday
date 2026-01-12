class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int totalseconds = 0;
        for(int i=1;i<points.length;i++){
            int xc = Math.abs(points[i][0]-points[i-1][0]);
            int yc = Math.abs(points[i][1]-points[i-1][1]);
            totalseconds += Math.max(xc,yc);
        }
        return totalseconds;
    }
}