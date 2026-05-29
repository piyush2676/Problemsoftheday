class Solution {
    public int minElement(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int sum = 0;
            int temp = nums[i];
            while(temp > 0){
                sum+=temp % 10;
                temp /= 10;
            }
            ans = Math.min(ans,sum);
        }
        return ans;
    }
}