class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] r = new int[60];
        for (int t : time) {
            r[t%60]++;
        }
        
        int ans = r[0] * (r[0]-1) / 2 + r[30] * (r[30]-1) / 2;
        for (int i = 1; i < 30; i++) {
            ans += r[i] * r[60-i];
        }
        
        return ans;
    }
}
