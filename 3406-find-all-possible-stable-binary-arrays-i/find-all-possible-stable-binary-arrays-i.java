class Solution {
    int mod = 1000000007;
    int[][][] dp = new int[201][201][2];
       public int solve(int zeroesleft,int onesleft,boolean lastwasone,int limit){
        if(zeroesleft == 0 && onesleft == 0){
            return 1;
        }
        if(dp[zeroesleft][onesleft][lastwasone ? 1 : 0] != -1)
    return dp[zeroesleft][onesleft][lastwasone ? 1 : 0];
        int result = 0;
        if(lastwasone  == true){
              for(int len = 1;len <= Math.min(zeroesleft,limit);len++){
                result = (result + solve(zeroesleft-len,onesleft,false,limit)) % mod;
              }
        }
        else{
            for(int len = 1;len <= Math.min(onesleft,limit);len++){
                result = (result + solve(zeroesleft,onesleft-len,true,limit)) % mod;;
            }
        }
        return dp[zeroesleft][onesleft][lastwasone ? 1 : 0] = result;
    }
    public int numberOfStableArrays(int zero, int one, int limit) {
        for(int i=0;i<201;i++){
            for(int j=0;j<201;j++){
                for(int k=0;k<2;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        int startwithone = solve(zero,one,false,limit);
        int startwithzero = solve(zero,one,true,limit);
        return (startwithone + startwithzero) % mod;
    }
}