class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O')
                dfs(i, 0, board, rows, cols);
            if (board[i][cols - 1] == 'O')
                dfs(i, cols-1, board, rows, cols);
        }
        for (int i = 0; i < cols; i++) {
            if (board[0][i] == 'O')
                dfs(0, i, board, rows, cols);
            if (board[rows - 1][i] == 'O')
                dfs(rows - 1, i, board, rows, cols);
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'Z') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        return;

    }

    private void dfs(int x, int y, char[][] board, int rows, int cols) {
        if (x < 0 || x >= rows || y < 0 || y >= cols) {
            return;
        }
        if (board[x][y] == 'X' || board[x][y] == 'Z')
            return;
        board[x][y] = 'Z';
        dfs(x + 1, y, board, rows, cols);
        dfs(x - 1, y, board, rows, cols);
        dfs(x, y + 1, board, rows, cols);
        dfs(x, y - 1, board, rows, cols);
    }
}