class Solution {
    public int minOperations(String s) {
        int min = Integer.MAX_VALUE;
        int n = s.length();
        int ans1 = 0;
        int ans2 = 0;
        for(int i=0;i<n;i++){
           char expected0 = (i % 2 == 0) ? '0' : '1';
           char expected1 = (i % 2 == 0) ? '1' : '0';

           if(s.charAt(i) != expected1){
            ans1++;
           }
           else if(s.charAt(i) != expected0){
            ans2++;
           }
        }
        return Math.min(ans1,ans2);
    }
}