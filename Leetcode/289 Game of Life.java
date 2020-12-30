class Solution {
    int m;
    int n;
    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int nei = countNei(board, i, j);
                if (board[i][j] == 1) {
                    if (nei == 2 || nei == 3) board[i][j] = 3;
                } else {
                    if (nei == 3) board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }
    
    private int countNei(int[][] board, int x, int y) {
        int cnt = 0;
        int xx = Math.max(0, x-1);
        int yy = Math.max(0, y-1);
        for (int i = xx; i <= x+1 && i < m; i++) {
            for (int j = yy; j <= y+1 && j < n; j++) {
                if (x == i && y == j) continue;
                cnt += board[i][j] & 1;
            }
        }
        return cnt;
    }
}
