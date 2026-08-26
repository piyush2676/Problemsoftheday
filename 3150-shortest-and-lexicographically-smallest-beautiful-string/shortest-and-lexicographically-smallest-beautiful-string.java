class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        String ans = "";
        for(int i = 0 ; i < n ; i++){
            StringBuilder s1 = new StringBuilder();
            int count = 0;
            for(int j = i ; j < n ; j++){
                s1.append(s.charAt(j));

                if(s.charAt(j) == '1'){
                    count++;
                }
                if(count == k){
                    int a = 0;
                    while(a < s1.length() && s1.charAt(a) == '0'){
                        a++;
                    }
                    String curr = s1.substring(a);

                    if(ans.equals("") || curr.length() < ans.length() || (curr.length() == ans.length() && curr.compareTo(ans) < 0)){
                        ans = curr;
                    }
                    break;
                }
            }
        }
        return ans;
    }
}