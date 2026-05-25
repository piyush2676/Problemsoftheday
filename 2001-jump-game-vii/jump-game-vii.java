class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
       int[] dp = new int[s.length()];
       for(int i=0;i<s.length();i++){
         dp[i] = 0;
       }
       dp[0] = 1;
       int cnt = 0;
       for(int j=1;j<=s.length()-1;j++){
         if(j-minJump >=0){
            cnt+= dp[j-minJump];
         }
         if(j-maxJump-1 >=0){
            cnt -= dp[j-maxJump-1];
         }
         if(cnt > 0 && s.charAt(j) == '0'){
            dp[j] = 1;
         }
       }
       return dp[s.length()-1] > 0;
    }
}