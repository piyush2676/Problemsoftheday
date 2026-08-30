class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int minPos = -1;
        int maxPos = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minPos = i;
            }

            if (nums[i] > max) {
                max = nums[i];
                maxPos = i;
            }
        }

        if (minPos > maxPos) {
            int temp = minPos;
            minPos = maxPos;
            maxPos = temp;
        }

        int left = maxPos + 1;

        int right = n - minPos;

        int both = (minPos + 1) + (n - maxPos);

        return Math.min(left, Math.min(right, both));
    }
}