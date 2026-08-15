class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        boolean zero = true;
        for(int i : nums){
            xor ^= i;

            if(xor != 0){
                zero = false;
            }
        }
        if(zero) return 0;
        return xor == 0 ? nums.length-1 : nums.length;
    }
}