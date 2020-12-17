class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int la = A.length;
        int lb = B.length;
        int lc = C.length;
        int ld = D.length;
        int lx = la*lb;
        int ly = lc*ld;
        
        int[] x = new int[lx];
        int[] y = new int[ly];
        
        int px = 0;
        for (int i : A) {
            for (int j : B) {
                x[px++] = i + j;
            }
        }
        Arrays.sort(x);

        int py = 0;
        for (int i : C) {
            for (int j : D) {
                y[py++] = i + j;
            }
        }
        Arrays.sort(y);
        
        int ans = 0;
        py--;
        px = 0;
        while (px < lx && py >= 0) {
            int sum = x[px] + y[py];
            if (sum == 0) {
                int cntX = 1, cntY = 1;
                px++; py--;
                while (px < lx && x[px] == x[px-1]) { cntX++; px++; }
                while (py >= 0 && y[py] == y[py+1]) { cntY++; py--; }
                ans += cntX * cntY;
            }
            else if (sum < 0) px++;
            else if (sum > 0) py--;
        }
        
        return ans;
    }
}
