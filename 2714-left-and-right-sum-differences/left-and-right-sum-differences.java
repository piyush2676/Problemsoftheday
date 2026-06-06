class Solution {
    public int[] leftRightDifference(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int[] ans = new int[nums.length];
        int cur = 0;
        for(int i=0;i<nums.length;i++){
            int leftsum = cur;
            cur+=nums[i];
            int rightsum = sum - cur;
            ans[i] = Math.abs(leftsum-rightsum);
        }
        return ans;
    }
}