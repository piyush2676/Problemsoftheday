class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        Set<Integer> st = new HashSet<>();
        for(int i : nums){
            st.add(i);
        }
        int seqsum = nums[0];
        for(int j=1;j<n;j++){
            if(nums[j] == nums[j-1] + 1){
               seqsum+=nums[j];
            }else{
                break;
            }
        }
        while(st.contains(seqsum)){
            seqsum++;
        }
        return seqsum;
    }
}