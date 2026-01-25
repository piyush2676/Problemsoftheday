class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int minidiff = Integer.MAX_VALUE;
        int i = 0;
        int j = k-1;
        while(j < n){;
            int minele = nums[i];
            int maxele = nums[j];

            minidiff = Math.min(minidiff,maxele-minele);
            i++;
            j++;

        }
        return minidiff;
    }
}