class Solution {
    final int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int largestIsland(int[][] grid) {
        int maxArea = Integer.MIN_VALUE;
        int n = grid.length;
        int m = grid[0].length;
        int colourId = 2;
        Map<Integer, Integer> colourArea = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int val = dfs(i, j, grid, n, m, colourId);
                    maxArea = Math.max(val, maxArea);
                    colourArea.put(colourId, val);
                    colourId++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    int potArea = 1;
                    for (int[] dir : dirs) {
                        int nx = i + dir[0];
                        int ny = j + dir[1];
                        if (isValid(nx, ny, m, n) && grid[nx][ny] != 0 && !set.contains(grid[nx][ny])) {
                            potArea += colourArea.get(grid[nx][ny]);
                            set.add(grid[nx][ny]);
                        }
                    }
                    maxArea = Math.max(maxArea, potArea);

                }
            }
        }
        return maxArea == Integer.MIN_VALUE ? 0 : maxArea;
    }

    private boolean isValid(int i, int j, int rows, int cols) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }

    private int dfs(int i, int j, int[][] arr, int rows, int cols, int visValue) {
        if (arr[i][j] == 0 || arr[i][j] == visValue)
            return 0;
        arr[i][j] = visValue;
        int val = 1;
        for (int[] dir : dirs) {
            int nx = i + dir[0];
            int ny = j + dir[1];
            if (isValid(nx, ny, rows, cols))
                val += dfs(nx, ny, arr, rows, cols, visValue);
        }
        return val;
    }
}