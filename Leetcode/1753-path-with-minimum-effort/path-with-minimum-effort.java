class Solution {
    int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        if(n==1 && m==1)return 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((p,q)->p[2]-q[2]);
        pq.add(new int[] { 0, 0, Integer.MIN_VALUE });
        boolean[][] visited=new boolean[n][m];
        visited[0][0]=true;
        int ans = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            int[] a = pq.poll();
            if (a[0] == n - 1 && a[1] == m - 1) {
                ans = Math.min(ans, a[2]);
                continue;
            }
            visited[a[0]][a[1]]=true;
            for (int[] dir : dirs) {
                int nx = a[0] + dir[0];
                int ny = a[1] + dir[1];
                if (isValid(nx, ny, n, m) && !visited[nx][ny]) {
                    int diff = Math.abs(heights[nx][ny] - heights[a[0]][a[1]]);
                    int maxDiff = Math.max(diff, a[2]);
                    pq.add(new int[] { nx, ny, maxDiff });
                }
            }
        }
        return ans;

    }

    private boolean isValid(int i, int j, int rows, int cols) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }
}