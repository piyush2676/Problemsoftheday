class Robot {
    int idx = 0;
    int[][] pos;
    boolean moved = false;

    public Robot(int width, int height) {
        // total perimeter points
        int size = (width * 2 + height * 2 - 4);
        pos = new int[size][3];

        int k = 0;

        // bottom row (left → right)
        for (int x = 0; x < width; x++) {
            pos[k++] = new int[]{x, 0, 0}; // East
        }

        // right column (bottom → top)
        for (int y = 1; y < height; y++) {
            pos[k++] = new int[]{width - 1, y, 1}; // North
        }

        // top row (right → left)
        for (int x = width - 2; x >= 0; x--) {
            pos[k++] = new int[]{x, height - 1, 2}; // West
        }

        // left column (top → bottom)
        for (int y = height - 2; y > 0; y--) {
            pos[k++] = new int[]{0, y, 3}; // South
        }
    }

    public void step(int num) {
        moved = true;
    idx = (idx + num) % pos.length;
}

    public int[] getPos() {
        return new int[]{pos[idx][0], pos[idx][1]};
    }

    public String getDir() {
           if (!moved) return "East";

    if (idx == 0) return "South";

    int d = pos[idx][2];
    if (d == 0) return "East";
    else if (d == 1) return "North";
    else if (d == 2) return "West";
    else return "South";
    }
}