class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = 0;
        }
        int sign = k > 0 ? 1 : -1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k*sign; j++) {
                int idx = i + j*sign;
                if (idx >= n) {
                    idx -= n;
                } else if (idx < 0) {
                    idx += n;
                }
                ans[i] += code[idx];
            }
        }
        return ans;
    }
}
