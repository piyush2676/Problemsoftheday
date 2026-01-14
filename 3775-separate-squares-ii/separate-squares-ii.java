import java.util.*;

class Solution {

    static class YEvent {
        double y;
        int x1, x2;
        int type;
        YEvent(double y, int x1, int x2, int type) {
            this.y = y;
            this.x1 = x1;
            this.x2 = x2;
            this.type = type;
        }
    }

    static class SegmentTree {
        int n;
        int[] count;
        long[] length;
        int[] xs;

        SegmentTree(int[] xs) {
            this.xs = xs;
            this.n = xs.length - 1;
            count = new int[4 * n];
            length = new long[4 * n];
        }

        void update(int node, int l, int r, int ql, int qr, int val) {
            if (qr <= l || r <= ql) return;
            if (ql <= l && r <= qr) {
                count[node] += val;
            } else {
                int mid = (l + r) >>> 1;
                update(node << 1, l, mid, ql, qr, val);
                update(node << 1 | 1, mid, r, ql, qr, val);
            }

            if (count[node] > 0)
                length[node] = xs[r] - xs[l];
            else if (l + 1 == r)
                length[node] = 0;
            else
                length[node] = length[node << 1] + length[node << 1 | 1];
        }

        long query() {
            return length[1];
        }
    }

    public double separateSquares(int[][] squares) {
        int n = squares.length;

        List<YEvent> events = new ArrayList<>();
        TreeSet<Integer> xSet = new TreeSet<>();

        for (int[] s : squares) {
            int x1 = s[0];
            int x2 = s[0] + s[2];
            int y1 = s[1];
            int y2 = s[1] + s[2];

            events.add(new YEvent(y1, x1, x2, +1));
            events.add(new YEvent(y2, x1, x2, -1));

            xSet.add(x1);
            xSet.add(x2);
        }

        int[] xs = new int[xSet.size()];
        int idx = 0;
        for (int x : xSet) xs[idx++] = x;

        Map<Integer, Integer> xIndex = new HashMap<>();
        for (int i = 0; i < xs.length; i++)
            xIndex.put(xs[i], i);

        events.sort(Comparator.comparingDouble(e -> e.y));

        SegmentTree st = new SegmentTree(xs);

        double totalArea = 0;
        double prevY = events.get(0).y;
        for (YEvent e : events) {
            double dy = e.y - prevY;
            totalArea += dy * st.query();

            st.update(1, 0, st.n,
                    xIndex.get(e.x1),
                    xIndex.get(e.x2),
                    e.type);

            prevY = e.y;
        }

        double half = totalArea / 2.0;
        st = new SegmentTree(xs);
        prevY = events.get(0).y;
        double areaSoFar = 0;

        for (YEvent e : events) {
            double dy = e.y - prevY;
            long activeWidth = st.query();

            if (areaSoFar + dy * activeWidth >= half) {
                return prevY + (half - areaSoFar) / activeWidth;
            }

            areaSoFar += dy * activeWidth;

            st.update(1, 0, st.n,
                    xIndex.get(e.x1),
                    xIndex.get(e.x2),
                    e.type);

            prevY = e.y;
        }

        return prevY;
    }
}
