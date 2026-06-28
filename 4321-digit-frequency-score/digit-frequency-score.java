class Solution {
    public int digitFrequencyScore(int n) {
        int ans = 0;
        while(n>0){
            int num = n % 10;
            ans+=num;
            n = n / 10;
        }
        return ans;
    }
}