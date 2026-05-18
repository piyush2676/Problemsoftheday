class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;

        Map<Integer, List<Integer>> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            mp.putIfAbsent(arr[i], new ArrayList<>());
            mp.get(arr[i]).add(i);
        }

        boolean[] vis = new boolean[n];

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        vis[0] = false;

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int cur = q.poll();

                if (cur == n - 1) return steps;

                int left = cur - 1;
                int right = cur + 1;

                if (left >= 0 && !vis[left]) {
                    q.offer(left);
                    vis[left] = true;
                }

                if (right < n && !vis[right]) {
                    q.offer(right);
                    vis[right] = true;
                }

                if (mp.containsKey(arr[cur])) {
                    for (int idx : mp.get(arr[cur])) {
                        if (!vis[idx]) {
                            q.offer(idx);
                            vis[idx] = true;
                        }
                    }

                    mp.remove(arr[cur]);
                }
            }

            steps++;
        }

        return -1;
    }
}