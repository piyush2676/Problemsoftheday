class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length<2) return 0;
        int maxproduct = Integer.MIN_VALUE;
        for(int i=0;i<nums.length-1;i++){
            int j = i+1;
            int prod = (nums[i]-1)*(nums[j]-1);
            if(prod > maxproduct) maxproduct = prod;
        }
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for(int x : nums){
            if(x > max1){
                max2 = max1;
                max1 = x;
            }
            else{
                if(x > max2){
                    max2 = x;
                }
            }
        }
        int prod = (max1-1)*(max2-1);
        return Math.max(prod,maxproduct);
    }
}