class Solution {
    public int numEnclaves(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1){
                queue.add(new int[] { i, 0 });
                grid[i][0]=2;
            }
            if (grid[i][n - 1] == 1){
                queue.add(new int[] { i, n - 1 });
                grid[i][n-1]=2;
            }
        }
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 1){
                queue.add(new int[] { 0, i });
                grid[0][i]=2;
            }
            if (grid[m - 1][i] == 1){
                queue.add(new int[] { m-1, i });
                grid[m-1][i]=2;
            }
        }
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!queue.isEmpty()) {
            int[] curr = queue.remove();
            int currx = curr[0];
            int curry = curr[1];

            for (int[] d : dirs) {
                int nx = currx + d[0];
                int ny = curry + d[1];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                    queue.add(new int[] { nx, ny });
                    grid[nx][ny]=2;
                }
            }

        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ans++;
                }
            }
        }
        return ans;

    }
}