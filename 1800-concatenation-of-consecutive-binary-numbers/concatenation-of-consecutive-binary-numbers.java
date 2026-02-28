class Solution {
    long mod = 1000000007;
    
    public long solve(int n){
        if(n == 1) return 1;
        
        long prev = solve(n - 1);

        int len = Integer.toBinaryString(n).length();
    
        long result = ((prev << len) % mod + n) % mod;
        
        return result;
    }
    
    public int concatenatedBinary(int n) {
        return (int) solve(n);
    }
}