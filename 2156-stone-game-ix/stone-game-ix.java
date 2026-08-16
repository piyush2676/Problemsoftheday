class Solution {
    public boolean stoneGameIX(int[] stones) {
        int n = stones.length;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for(int i=0;i<n;i++){
            if( stones[i] % 3 == 0)  count1++;
            else if(stones[i] % 3 == 1) count2++;
            else count3++;
        }
        if(count1 % 2 == 0){
            return count2 > 0 && count3 > 0;
        }
        return Math.abs(count2-count3) > 2;
    }
}