class Solution {
    static final int MOD = 1_000_000_007;

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {

        List<Integer> h = new ArrayList<>();
        List<Integer> v = new ArrayList<>();

        h.add(1);
        h.add(m);
        v.add(1);
        v.add(n);

        for (int x : hFences) h.add(x);
        for (int x : vFences) v.add(x);

        Collections.sort(h);
        Collections.sort(v);

        Set<Integer> hDist = new HashSet<>();
        Set<Integer> vDist = new HashSet<>();
        for (int i = 0; i < h.size(); i++) {
            for (int j = i + 1; j < h.size(); j++) {
                hDist.add(h.get(j) - h.get(i));
            }
        }
        for (int i = 0; i < v.size(); i++) {
            for (int j = i + 1; j < v.size(); j++) {
                vDist.add(v.get(j) - v.get(i));
            }
        }

        long maxSide = -1;
        for (int d : hDist) {
            if (vDist.contains(d)) {
                maxSide = Math.max(maxSide, d);
            }
        }

        if (maxSide == -1) return -1;

        return (int) ((maxSide * maxSide) % MOD);
    }
}
