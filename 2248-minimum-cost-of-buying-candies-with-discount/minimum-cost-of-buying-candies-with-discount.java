class Solution {
    public int minimumCost(int[] cost) {
        // Arrays.sort(cost);
        // int n = cost.length;
        // int count = 0;
        // int mincost = 0;
        // for(int i = n - 1; i>=0;i--){
        //     count++;
        //     if(count % 3 != 0){
        //           mincost+=cost[i];
        //     }
        // }
        // return mincost;
        Arrays.sort(cost);
        int total = 0;
        int n = cost.length;
        for(int i=n-1;i>=0;i--){
            if((n-1-i) % 3 != 2) total+=cost[i]; //skipping every third index
        }
        return total;
    }
}