class Solution {
    private int[] tbl;
    public int countArrangement(int n) {
        tbl = new int[1<<n];
        tbl[(1<<n) - 1] = 1;
        return dfs(0, 1, n);
    }
    
    private int dfs(int state, int curr, int n) {
        if (tbl[state] != 0) return tbl[state];
        
        for (int i = 1; i <= n; i++) {
            if ((state & 1<<(i-1)) == 0) {
                if (curr % i == 0 || i % curr == 0) {
                    tbl[state] += dfs(state | 1<<(i-1), curr+1, n);
                }
            }
        }
        return tbl[state];
    }
}
