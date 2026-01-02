class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2)
                    queue.add(new int[] { i, j });
            }
        }
        int levels = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] c = queue.remove();
                int x = c[0];
                int y = c[1];
                if (x > 0 && grid[x - 1][y] == 1) {
                    grid[x - 1][y] = 2;
                    queue.add(new int[] { x - 1, y });
                }
                if (x < n - 1 && grid[x + 1][y] == 1) {
                    grid[x + 1][y] = 2;
                    queue.add(new int[] { x + 1, y });
                }
                if (y > 0 && grid[x][y - 1] == 1) {
                    grid[x][y - 1] = 2;
                    queue.add(new int[] { x, y - 1 });
                }
                if (y < m - 1 && grid[x][y + 1] == 1) {
                    grid[x][y + 1] = 2;
                    queue.add(new int[] { x, y + 1 });
                }
            }
            levels++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }
        return levels == 0 ? levels : levels - 1;
    }
}