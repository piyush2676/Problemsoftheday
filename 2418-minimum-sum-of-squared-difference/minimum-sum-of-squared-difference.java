class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] diff = new int[n];
        long total = 0;
        int max = 0;
        for(int i = 0 ; i < n ; i++){
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            total += diff[i];
            max = Math.max(max,diff[i]);
        }
        long k = (long) k1+k2;
        if(total <= k) return 0;
        int l = 0;
        int r = max;
        while(l <= r){
            int mid = l + (r-l) /2;
            long req = 0;
            for(int i : diff){
                req += Math.max(0,i-mid);
            }
                if(req <= k) r = mid-1;
                else l = mid + 1;
        }
        for(int i = 0 ; i < n ; i++){
            k-=Math.max(0,diff[i] - l);
            diff[i] = Math.min(diff[i],l);
        }
        for(int i = 0 ; i < n && k > 0; i++){
            if(diff[i] == l){
                --diff[i];
                --k;
            }
        }
        long ans = 0;
        for(int i : diff){
            ans += (long) i * i;
        }
        return ans;
    }
}