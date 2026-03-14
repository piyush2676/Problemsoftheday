class Solution {
    List<String> result = new ArrayList<>(); 
    public void backtrack(int n,StringBuilder cur,List<String> result){
        if(cur.length() == n){
            result.add(cur.toString());
            return;
        }
        for(char ch = 'a'; ch<='c';ch++){
            if(cur.length() > 0 && cur.charAt(cur.length()-1) == ch)continue;
            cur.append(ch);
            backtrack(n,cur,result);
            cur.deleteCharAt(cur.length()-1);
        }
    }
    public String getHappyString(int n, int k) {
        backtrack(n,new StringBuilder(),result);
        if(k > result.size()){
            return "";
        }
        return result.get(k-1);
    }
}