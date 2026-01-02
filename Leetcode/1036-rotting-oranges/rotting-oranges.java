class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int freshCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2)
                    queue.add(new int[] { i, j });
                if (grid[i][j] == 1)
                    freshCount++;
            }
        }
        if (freshCount == 0)
            return 0;
        int levels = 0;
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedThisTurn = false;
            while (size-- > 0) {
                int[] curr = queue.poll();
                for (int[] d : dirs) {
                    int nx = curr[0] + d[0];
                    int ny = curr[1] + d[1];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        queue.add(new int[] { nx, ny });
                        freshCount--;
                        rottedThisTurn = true;
                    }
                }
            }
            if (rottedThisTurn)
                levels++;
        }
        return freshCount == 0 ? levels : -1;
    }
}