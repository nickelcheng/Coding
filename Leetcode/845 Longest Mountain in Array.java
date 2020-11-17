class Solution {
    public int longestMountain(int[] A) {
        int ans = 0;
        int currIdx = 0;
        while (currIdx + 1 < A.length) {
            int upSize = 1;
            while (currIdx + 1 < len && A[currIdx] < A[currIdx + 1]) {
                upSize++;
                currIdx++;
            }
            if (upSize <= 1) {
                currIdx++;
                continue;
            }
            int downSize = 0;
            while (currIdx + 1 < A.length && A[currIdx] > A[currIdx + 1]) {
                downSize++;
                currIdx++;
            }
            if (downSize > 0) {
                ans = Math.max(ans, upSize + downSize);
            }
        }
        return ans;
    }
}
