class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int F = 0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            F += i * nums[i];
        }
        int result = F;
        for(int j = 0;j<=n-1;j++){
            int newF = F + sum - n * nums[n-1-j];
            result = Math.max(result,newF);
            F = newF;
        }
        return result;
    }
}