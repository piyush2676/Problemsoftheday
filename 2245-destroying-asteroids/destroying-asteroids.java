class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long MASS = mass;
        for(int m : asteroids){
            if(MASS < m){
                return false;
            }
            MASS+=m;
        }
        return true;
    }
}