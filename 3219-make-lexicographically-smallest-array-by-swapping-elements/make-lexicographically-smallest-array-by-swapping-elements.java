class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] medio = nums.clone();
        Arrays.sort(medio);
        List<List<Integer>> ls = new ArrayList<>();
        Map<Integer,Integer> mp = new HashMap<>();
        int id = -1;
        for(int i = 0 ; i < medio.length;i++){
            if(i == 0 || medio[i] - medio[i-1] > limit){
                ls.add(new ArrayList<>());
                id++;
            }
            ls.get(id).add(medio[i]);
            mp.put(medio[i],id);
        }
        int[] idx = new int[ls.size()];
        for(int i = 0 ; i < nums.length; i++){
            int cur = mp.get(nums[i]);
            nums[i] = ls.get(cur).get(idx[cur]);
            idx[cur]++;
        }
        return nums;
    }
}