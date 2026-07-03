class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int prefixsum = nums[0];
        for(int i=1;i<n;i++){
            nums[i] = prefixsum+=nums[i];
        }
        return nums;
    }
}