class Solution {
    public int minMoves(int[] nums) {
        int x = Arrays.stream(nums).min().getAsInt();
        int moves = 0;
        for(int i : nums){
            moves += i - x;
        }
        return moves;
    }
}