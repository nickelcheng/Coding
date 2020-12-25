class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return new int[0];
        int n = matrix[0].length;
        
        int[] ans = new int[m*n];
        int idx = 0;
        int x = 0;
        int y = 0;
        while (x != m-1 || y != n-1) {
            ans[idx++] = matrix[x][y];
            if ((x+y) % 2 == 0) {
                y++;
                x--;
                if (y >= n) { y--; x += 2; }
                if (x < 0) x++;
            } else {
                x++;
                y--;
                if (x >= m) { x--; y += 2; }
                if (y < 0) y++;
            }
        }
        
        ans[idx] = matrix[m-1][n-1];
        
        return ans;
    }
}
