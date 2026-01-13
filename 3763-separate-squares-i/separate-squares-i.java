class Solution {
    public double separateSquares(int[][] squares) {
        int n = squares.length;
        double low = Double.MAX_VALUE;
        double high = -Double.MIN_VALUE;
        double totalArea = 0.0;
        for(int[] i : squares){
            double y = i[1];
            double l = i[2];
            low = Math.min(low,y);
            high = Math.max(high,y+l);
            totalArea +=l*l;
        }
        double target = totalArea / 2.0;
        for(int j=0;j<100;j++){
            double mid = (low+high)/2.0;
            double areadown = 0.0;
            for(int[] s : squares){
              double y = s[1];
              double l = s[2];
              if(mid <= y){
                continue;
              }
              else if(mid >= y+l){
                areadown +=l*l;
              }
              else{
                areadown += l*(mid - y);
              }
            }
            if(areadown < target){
                low = mid;
            }
            else{
                high = mid;
            }
        }
        return (low+high)/2.0;
    }
}