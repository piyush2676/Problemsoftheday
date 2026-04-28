class Solution {
    public void backtrack(List<List<Integer>> ls,List<Integer> temp,int[] nums,boolean[] picked){
         if(nums.length == temp.size()){
            ls.add(new ArrayList<>(temp));
            return;
         }
         for(int i=0;i<nums.length;i++){
            if(picked[i]) continue;

            picked[i] = true;
            temp.add(nums[i]);
            backtrack(ls,temp,nums,picked);
            temp.remove(temp.size()-1);
            picked[i] = false;
         }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        int n = nums.length;
        boolean[] picked = new boolean[n];
        backtrack(ls,new ArrayList<>(),nums,picked);
        return ls;
    }
}