class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> st = new HashSet<>();
        for(int i  : nums){
            st.add(i);
        }
        int cur = k;
        while(st.contains(cur)){
            cur += k;
        }
        return cur;
    }
}