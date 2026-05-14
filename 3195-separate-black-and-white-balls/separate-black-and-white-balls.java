class Solution {
    public long minimumSteps(String s) {
        int count_black = 0;
        long steps = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '1') count_black++;
            if(s.charAt(i) == '0') steps+=count_black;
        }
        return steps;
    }
}