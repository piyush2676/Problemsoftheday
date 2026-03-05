class Solution {
    public void backtrack(int[] nums,int idx,List<Integer> cur,List<List<Integer>> result){
        int n = nums.length;
        Set<Integer> st = new HashSet<>();
        if(cur.size() >= 2){
            result.add(new ArrayList<>(cur));
        }
        for(int i=idx;i<n;i++){
            if((cur.isEmpty() || nums[i] >= cur.get(cur.size()-1)) && (!st.contains(nums[i]))){
                 cur.add(nums[i]);
                 backtrack(nums,i+1,cur,result);
                 cur.remove(cur.size()-1);
                 st.add(nums[i]);
            }
        }
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        int n = nums.length;
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums,0,cur,result);
        return result;
    }
}