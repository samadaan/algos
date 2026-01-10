class Solution {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        
        // dist[i][j] stores the minimum effort required to reach cell (i, j)
        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        
        // Priority Queue stores {row, col, effort}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        
        dist[0][0] = 0;
        pq.add(new int[]{0, 0, 0});
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0], c = curr[1], effort = curr[2];
            
            // If we found a better way to this cell already, skip
            if (effort > dist[r][c]) continue;
            
            // If we reached the end, this is the minimum effort due to PQ property
            if (r == n - 1 && c == m - 1) return effort;
            
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                
                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    // Effort to move to neighbor is the max of 
                    // current path effort and the current step's jump
                    int newEffort = Math.max(effort, Math.abs(heights[r][c] - heights[nr][nc]));
                    
                    if (newEffort < dist[nr][nc]) {
                        dist[nr][nc] = newEffort;
                        pq.add(new int[]{nr, nc, newEffort});
                    }
                }
            }
        }
        return 0;
    }
}