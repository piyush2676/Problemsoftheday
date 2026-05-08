class Solution {

    boolean[] isPrime;

    public void sieve(int maxEle) {

        isPrime = new boolean[maxEle + 1];

        Arrays.fill(isPrime, true);

        if (maxEle >= 0) isPrime[0] = false;
        if (maxEle >= 1) isPrime[1] = false;

        for (int num = 2; num * num <= maxEle; num++) {

            if (isPrime[num]) {

                for (int multiple = num * num;
                     multiple <= maxEle;
                     multiple += num) {

                    isPrime[multiple] = false;
                }
            }
        }
    }

    public int minJumps(int[] nums) {

        int n = nums.length;

        Map<Integer, List<Integer>> mp = new HashMap<>();

        int maxEle = 0;

        for (int i = 0; i < n; i++) {

            mp.putIfAbsent(nums[i], new ArrayList<>());
            mp.get(nums[i]).add(i);

            maxEle = Math.max(maxEle, nums[i]);
        }

        sieve(maxEle);

        Queue<Integer> q = new LinkedList<>();

        boolean[] visited = new boolean[n];

        q.offer(0);
        visited[0] = true;

        int steps = 0;

        Set<Integer> seen = new HashSet<>();

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int i = q.poll();

                if (i == n - 1) {
                    return steps;
                }

                if (i - 1 >= 0 && !visited[i - 1]) {

                    q.offer(i - 1);
                    visited[i - 1] = true;
                }

                if (i + 1 < n && !visited[i + 1]) {

                    q.offer(i + 1);
                    visited[i + 1] = true;
                }

                if (!isPrime[nums[i]] || seen.contains(nums[i])) {
                    continue;
                }

                for (int multiple = nums[i];
                     multiple <= maxEle;
                     multiple += nums[i]) {

                    if (!mp.containsKey(multiple)) {
                        continue;
                    }

                    for (int j : mp.get(multiple)) {

                        if (!visited[j]) {

                            q.offer(j);
                            visited[j] = true;
                        }
                    }
                }

                seen.add(nums[i]);
            }

            steps++;
        }

        return 0;
    }
}