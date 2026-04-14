class Solution {
    Long dp[][];
    public long solve(int i,int j,List<Integer> robot,List<Integer> positions){
        if(i >= robot.size()) return 0;
        if(j >= positions.size()) return (long)1e15;

        if(dp[i][j] != null) return dp[i][j];

        long take = Math.abs(robot.get(i)-positions.get(j))+solve(i+1,j+1,robot,positions);
        long skip = solve(i,j+1,robot,positions);
        return dp[i][j] =  Math.min(take,skip);
    }
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Arrays.sort(factory,(a,b)->a[0]-b[0]);
        Collections.sort(robot);

        List<Integer> positions = new ArrayList<>();
        for(int i=0;i<factory.length;i++){
            int limit = factory[i][1];
            int pos = factory[i][0];


            for(int j=0;j<limit;j++){
                positions.add(pos);
            }
        }
        dp = new Long[robot.size()][positions.size()];
        return solve(0,0,robot,positions);
    }
}