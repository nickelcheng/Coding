class Solution {
    public int minimumDeletions(String s) {
        int len = s.length();
        int[] preB = new int[len];
        int[] postA = new int[len];
        preB[0] = 0;
        for (int i = 1; i < len; i++) {
            preB[i] = preB[i-1];
            if (s.charAt(i-1) == 'b') preB[i]++;
        }
        postA[len-1] = 0;
        for (int i = len-2; i >= 0; i--) {
            postA[i] = postA[i+1];
            if (s.charAt(i+1) == 'a') postA[i]++;
        }
        int ans = len;
        for (int i = 0; i < len; i++) {
            int curr = preB[i] + postA[i];
            if (curr < ans) {
                ans = curr;
            }
        }
        return ans;
    }
}
