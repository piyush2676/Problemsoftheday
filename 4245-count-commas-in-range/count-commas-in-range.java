class Solution {
    public int countCommas(int n) {
        int len = 0;
        for(int i = 1; i <= n ; i++) {
            int x = i;
            while(x >= 1000){
                len++;
                x /= 1000;
            }
        }
        return len;
    }
}