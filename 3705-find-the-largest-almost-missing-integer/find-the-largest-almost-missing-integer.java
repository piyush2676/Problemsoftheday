class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int[] freq = new int[51];
        for(int i : nums){
            freq[i]++;
        }
        int ans = -1;
        for(int i=0;i<n;i++){
        if(k==n || (freq[nums[i]] == 1 && (k==1 || i==0 || i==n-1))) ans = Math.max(ans,nums[i]);
        }
     return ans;
    }
}