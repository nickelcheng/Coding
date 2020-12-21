class Solution {
    public int smallestRangeII(int[] A, int K) {
        int len = A.length;
        if (len == 1) return 0;

        Arrays.sort(A);
        int min = A[0] + K;
        int max = A[len-1] - K;
        
        int ans = A[len-1] - A[0];
        for (int i = 1; i < len; i++) {
            int left = A[i-1] + K;
            int right = A[i] - K;
            
            int diff = Math.max(max, left) - Math.min(min, right);
            ans = Math.min(ans, diff);
        }
        
        return ans;
    }
}
