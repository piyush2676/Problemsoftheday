class Solution {
    public int waviness(int num){
        String s = Integer.toString(num);
        int n = s.length();
        if( n < 3) return 0;
        int score = 0;
        for(int i = 1;i<=n-2;i++){
            if(s.charAt(i) > s.charAt(i-1) && s.charAt(i) > s.charAt(i+1)){
                score++;
            }if(s.charAt(i) < s.charAt(i-1) && s.charAt(i) < s.charAt(i+1)){
                score++;
            }
        }
        return score;
    }
    public int totalWaviness(int num1, int num2) {
        int score = 0;
        for(int i = num1;i<=num2;i++){
            score+=waviness(i);
        }
        return score;
    }
}