class Solution {
    public int numRookCaptures(char[][] board) {
        int x = -1;
        int y = -1;
        for (int i = 0; i < 8 && x == -1; i++) {
            for (int j = 0; j < 8 && y == -1; j++) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                }
            }
        }
        int ans = 0;
        for (int i = x-1; i >= 0; i--) {
            if (board[i][y] == 'p') ans++;
            if (board[i][y] != '.') break;
        }
        for (int i = x+1; i < 8; i++) {
            if (board[i][y] == 'p') ans++;
            if (board[i][y] != '.') break;
        }
        for (int i = y-1; i >= 0; i--) {
            if (board[x][i] == 'p') ans++;
            if (board[x][i] != '.') break;
        }
        for (int i = y+1; i < 8; i++) {
            if (board[x][i] == 'p') ans++;
            if (board[x][i] != '.') break;
        }
        return ans;
    }
}
