class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        int minele = Integer.MAX_VALUE;
        for(int i = n-1;i>=0;i--){
            minele = Math.min(minele,nums[i]);
            ans[i] = minele;
        }
        int maxele = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            maxele = Math.max(maxele,nums[i]);

            if(maxele - ans[i] <= k){
                return i;
            }
        }
        return -1;
    }
}