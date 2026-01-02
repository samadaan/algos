class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(color==image[sr][sc]){
            return image;
        }
        dfs(image, sr, sc, image[sr][sc], color, image.length, image[0].length);
        return image;
    }
    private void dfs(int[][] arr, int x, int y, int currColor, int destColor, int rows, int cols){
        if(x<0 || x>=rows || y<0 || y>=cols){
            return;
        }
        if(arr[x][y]!=currColor){
            return;
        }
        arr[x][y]=destColor;
        dfs(arr, x+1, y, currColor, destColor, rows, cols);
        dfs(arr, x-1, y, currColor, destColor, rows, cols);
        dfs(arr, x, y+1, currColor, destColor, rows, cols);
        dfs(arr, x, y-1, currColor, destColor, rows, cols);
        
    }
}