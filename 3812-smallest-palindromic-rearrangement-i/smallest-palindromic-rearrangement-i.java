class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int half = n / 2;
        char[] chars = s.toCharArray();
        Arrays.sort(chars,0,half);
        for(int i=0;i<half;i++){
            chars[n-i-1] = chars[i];
        }
        return new String(chars);
    }
}