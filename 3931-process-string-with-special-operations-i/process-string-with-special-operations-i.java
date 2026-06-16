class Solution {
    public String processStr(String s) {
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(ch >= 'a' && ch <='z') ans.append(ch);
            if(ch == '#') ans.append(ans.toString());
            if(ch == '%') ans.reverse();
            if(ch == '*') {
                if(ans.length() > 0){
                    ans.deleteCharAt(ans.length()-1);
                }
            }
        }
        return ans.toString();
    }
}