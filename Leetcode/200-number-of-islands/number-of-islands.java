class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int col = grid[0].length;
        int[][] state = new int[rows][col];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                if (state[i][j] == 0 && grid[i][j] == '1') {
                    dfs(i, j, grid, state, rows, col);
                    count++;
                }
            }
        }
        return count;

    }

    private void dfs(int x, int y, char[][] grid, int[][] state, int rows, int cols) {
        if (x < 0 || x >= rows || y < 0 || y >= cols)
            return;

        if (state[x][y] == 1)
            return;

        if (grid[x][y] == '0')
            return;

        state[x][y] = 1;
        dfs(x + 1, y, grid, state, rows, cols);
        dfs(x - 1, y, grid, state, rows, cols);
        dfs(x, y + 1, grid, state, rows, cols);
        dfs(x, y - 1, grid, state, rows, cols);
    }
}