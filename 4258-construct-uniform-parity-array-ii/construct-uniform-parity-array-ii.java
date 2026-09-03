class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = Integer.MAX_VALUE;
        int oddcount = 0;
        for(int x : nums1){
            min = Math.min(min,x);
            if(x%2 == 1) oddcount++;
        }
        return min % 2 != 0 || oddcount == 0;
    }
}