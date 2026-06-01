class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n = cost.length;
        int count = 0;
        int mincost = 0;
        for(int i = n - 1; i>=0;i--){
            count++;
            if(count % 3 != 0){
                  mincost+=cost[i];
            }
        }
        return mincost;
    }
}