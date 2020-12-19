class Solution {
    private int[][][] tbl;
    public int cherryPickup(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        tbl = new int[r][c][c];
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                Arrays.fill(tbl[i][j], -1);
            }
        }

        tbl[0][0][c-1] = grid[0][0] + grid[0][c-1];
        
        int ans = 0;
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < c; j++) {
                ans = Math.max(ans, dp(r-1, i, j, grid));
            }
        }
        return ans;
    }
    
    private int dp(int r, int r1, int r2, int[][] grid) {
        int c = grid[0].length;
        if (r1 > r || r2 < c-1-r) return Integer.MIN_VALUE;
        if (tbl[r][r1][r2] != -1) return tbl[r][r1][r2];
        
        int ans = 0;
        int pickup = grid[r][r1] + ((r1 != r2) ? grid[r][r2] : 0);
        for (int i = r1-1; i <= r1+1; i++) {
            if (i < 0 || i >= c) continue;
            for (int j = r2-1; j <= r2+1; j++) {
                if (j < 0 || j >= c) continue;
                int val = pickup + dp(r-1, i, j, grid);
                ans = Math.max(ans, val);
            }
        }
        tbl[r][r1][r2] = ans;
        return ans;
    }
}
