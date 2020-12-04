class Solution {
    public int kthFactor(int n, int k) {
        int sqN = (int) Math.sqrt(n);
        boolean oddFactor = (sqN * sqN == n);
        int cnt = 0;
        for (int i = 1; i <= sqN; i++) {
            if (n % i == 0) cnt++;
            if (cnt == k) return i;
        }
        k = oddFactor ? 2*cnt - k : 2*cnt - k + 1;
        if (k <= 0) return -1;
        for (int i = 1; i <= sqN; i++) {
            if (n % i == 0) k--;
            if (k == 0) return n/i;
        }
        return -1;
    }
}
