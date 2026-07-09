class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] component = new int[n];
        int compid = 0;
        component[0] = compid;
        for(int i=1;i<n;i++){
            if(nums[i] - nums[i-1] > maxDiff){
                compid++;
            }
            component[i] = compid;
        }
        boolean[] result = new boolean[queries.length];
        for(int j=0;j<queries.length;j++){
            result[j] = (component[queries[j][0]] == component[queries[j][1]]);
        }
        return result;        
    }
}