import java.util.*;

class Solution {

    public int minimumPairSum(List<Integer> nums) {
        int minSum = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < nums.size() - 1; i++) {
            int sum = nums.get(i) + nums.get(i + 1);
            if (sum < minSum) {
                minSum = sum;
                index = i;
            }
        }
        return index;
    }

    private boolean isSorted(List<Integer> nums) {
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < nums.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public int minimumPairRemoval(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int n : nums) ans.add(n);

        int operationCount = 0;

        while (!isSorted(ans)) {
            int index = minimumPairSum(ans);
            int merged = ans.get(index) + ans.get(index + 1);
            ans.set(index, merged);
            ans.remove(index + 1);

            operationCount++;
        }

        return operationCount;
    }
}
