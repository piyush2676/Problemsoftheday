class Solution {
    public boolean Check(long mid,int[] workerTimes,int mh){
        long h = 0;
        for(int t : workerTimes){
            h += (long) (Math.sqrt(2.0 * mid/t + 0.25)-0.5);
            if( h>= mh){
                return true;
            }
        }
        return h >= mh;
    }
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
         int maxtime = Integer.MIN_VALUE;
         for(int it : workerTimes){
            maxtime = Math.max(maxtime,it);
         }
         long l = 1;
         long r =1L* maxtime * mountainHeight * (mountainHeight+1)/2;
         long result = 0;

         while(l<=r){
            long mid = l + (r-l)/2;
            if(Check(mid,workerTimes,mountainHeight)){
                result = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
         }
         return result;
    }
}