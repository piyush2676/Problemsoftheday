class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int n = moves.length();
        int count_l = 0;
        int count_r = 0;
        int count_ = 0;
        int dis = 0;
        for(int i=0;i<n;i++){
            if(moves.charAt(i) == 'L'){
                count_l++;
            }else if(moves.charAt(i) == 'R'){
                count_r++;
            }else{
                count_++;
            }
            dis = Math.abs(count_l-count_r) + count_;
        }
        return dis;
    }
}