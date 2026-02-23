class Solution {
    public boolean hasAllCodes(String s, int k) {
        StringBuilder s1 = new StringBuilder(s);
        Set<String> set = new HashSet<>();
        int n = s.length();
        int codes = 1<<k;
        for(int i=k;i<=n;i++){
           String substr = s1.substring(i-k,i);
            if(!set.contains(substr)){
                set.add(substr);
                codes--;
            }
            if(codes == 0){
                return true;
            }
        }
        return false;
    }
}