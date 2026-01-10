class Solution {
    int[][] dirs = { { 1, 0 }, { 1, 1 }, { 0, 1 }, { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 }, { -1, 1 } };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 1;
        Queue<int[]> queue = new LinkedList<>();
        if (grid[0][0] == 1)
            return -1;
        queue.offer(new int[] { 0, 0 });
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] a = queue.poll();
                if (a[0] == n - 1 && a[1] == m - 1) {
                    return count;
                }
                for (int[] dir : dirs) {
                    int nx = a[0] + dir[0];
                    int ny = a[1] + dir[1];
                    if (isValid(nx, ny, n, m) && grid[nx][ny] == 0) {
                        grid[nx][ny] = 1;
                        queue.add(new int[] { nx, ny });
                    }
                }
            }
            count++;
        }
        return -1;

    }

    private boolean isValid(int i, int j, int rows, int cols) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }
}