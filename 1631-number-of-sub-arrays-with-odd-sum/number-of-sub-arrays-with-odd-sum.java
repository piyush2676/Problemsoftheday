class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;
        long odd = 0;
        long even = 0;
        long ans = 0;
        for(int i : arr){
            if( i % 2 == 1){
                long newodd = even + 1;
                long neweven = odd;
                odd = newodd;
                even = neweven;
            }else{
                even = even + 1;
            }
            ans = (ans + odd) % MOD;
        }
        return (int) ans;
    }
}