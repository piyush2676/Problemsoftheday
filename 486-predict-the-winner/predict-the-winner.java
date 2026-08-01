class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        int player1_score = f(0,n-1,nums);
        int player2_score = sum - player1_score;
        if(player1_score >= player2_score) return true;
        return false;
    }
    public int f(int i,int j,int[] nums){
        if(i>j) return 0;
        if(i==j) return nums[j];
        int take_i = nums[i] + Math.min(f(i+2,j,nums),f(i+1,j-1,nums));
        int take_j = nums[j] + Math.min(f(i+1,j-1,nums),f(i,j-2,nums));

        return Math.max(take_i,take_j);
    }
}