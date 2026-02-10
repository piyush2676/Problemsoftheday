class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> evenno = new HashSet<>();
            Set<Integer> oddno = new HashSet<>();

            for (int j = i; j < n; j++) {
                if (nums[j] % 2 == 0) {
                    evenno.add(nums[j]);
                } else {
                    oddno.add(nums[j]);
                }

                if (evenno.size() == oddno.size()) {
                    result = Math.max(result, j - i + 1);
                }
            }
        }
        return result;
    }
}