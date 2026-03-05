class Solution {

    int result = Integer.MAX_VALUE;

    public void backtrack(int[] cookies, int[] children, int idx, int k) {

        int n = cookies.length;

        if (idx >= n) {

            int unfairness = 0;
            for (int child : children) {
                unfairness = Math.max(unfairness, child);
            }

            result = Math.min(result, unfairness);

            return;
        }

        int cookie = cookies[idx];

        for (int i = 0; i < k; i++) {

            children[i] += cookie;

            backtrack(cookies, children, idx + 1, k);

            children[i] -= cookie;
        }
    }

    public int distributeCookies(int[] cookies, int k) {

        int[] children = new int[k];

        backtrack(cookies, children, 0, k);

        return result;
    }
}