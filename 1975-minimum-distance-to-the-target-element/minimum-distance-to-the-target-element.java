class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;
        int abs = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=n-1;j>=0;j--){
                if(nums[i] == target){
                  abs = Math.min(abs,Math.abs(i-start));
                }
            }
        }
        return abs;
    }
}