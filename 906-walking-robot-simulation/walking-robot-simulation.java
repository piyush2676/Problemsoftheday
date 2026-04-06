class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
          // Directions: N, E, S, W
        int[][] dirs = {
            {0,1}, {1,0}, {0,-1}, {-1,0}
        };

        int d = 0; // start facing North
        int x = 0, y = 0;
        int maxDist = 0;

        // store obstacles
        Set<String> set = new HashSet<>();
        for (int[] o : obstacles) {
            set.add(o[0] + "," + o[1]);
        }

        for (int cmd : commands) {

            if (cmd == -1) { // turn right
                d = (d + 1) % 4;
            } 
            else if (cmd == -2) { // turn left
                d = (d + 3) % 4;
            } 
            else {
                // move step by step
                for (int i = 0; i < cmd; i++) {

                    int newX = x + dirs[d][0];
                    int newY = y + dirs[d][1];

                    // check obstacle
                    if (set.contains(newX + "," + newY)) {
                        break;
                    }

                    x = newX;
                    y = newY;

                    maxDist = Math.max(maxDist, x*x + y*y);
                }
            }
        }

        return maxDist;
    }
}