class Solution {
    public int smallestRepunitDivByK(int K) {
        boolean[] tbl = new boolean[K];
        Arrays.fill(tbl, false);
        int N = 1;
        int r = 1 % K;
        while (r != 0) {
            if (tbl[r]) return -1;
            tbl[r] = true;
            r = (10*r + 1) % K;
            N++;
        }
        return N;
    }
}
// 0:00 start thinking
// 15:00 start coding
// 18:22 AC
