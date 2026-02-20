import java.util.*;

class Solution {
    
    public String solve(String s){
        int n = s.length();
        List<String> specials = new ArrayList<>();
        
        int count = 0;
        int start = 0;
        
        for(int i = 0; i < n; i++){
            count += s.charAt(i) == '1' ? 1 : -1;
            
            if(count == 0){
  
                String inner = s.substring(start + 1, i);
                
                String special = "1" + solve(inner) + "0";
                
                specials.add(special);
                start = i + 1;
            }
        }
        
        Collections.sort(specials, Collections.reverseOrder());
        
        StringBuilder result = new StringBuilder();
        for(String str : specials){
            result.append(str);
        }
        
        return result.toString();
    }
    
    public String makeLargestSpecial(String s) {
        return solve(s);
    }
}