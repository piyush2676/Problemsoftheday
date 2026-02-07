class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] left_b = new int[n];
        int[] right_a = new int[n];
        int bcount = 0;
        for(int i=0;i<n;i++){
            left_b[i] = bcount;
            if(s.charAt(i) == 'b'){
                bcount++;
            }
        }
        int acount = 0;
        for(int i=n-1;i>=0;i--){
            right_a[i] = acount;
            if(s.charAt(i) == 'a'){
                acount++;
            }
        }
        int count = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            count = Math.min(count,left_b[i]+right_a[i]);
        }
        return count;
    }
}