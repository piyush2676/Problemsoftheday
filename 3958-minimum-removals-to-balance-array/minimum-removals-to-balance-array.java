class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int i = 0;
        int j = 0;
        int length = 1;
        int maxi = nums[0];
        int mini = nums[0];
        while(j<n){
            maxi = nums[j];
            mini = nums[i];
            while(i<j && maxi > (long)mini * k){
                i++;
                mini = nums[i];
            }
            length = Math.max(length,j-i+1);
            j++;
        }
        return n-length;
    }
}