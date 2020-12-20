class Solution {
    public String decodeAtIndex(String S, int K) {
        long k = K;
        int len = S.length();
        long[] totalLen = new long[len];
        totalLen[0] = 1;
        for (int i = 1; i < len; i++) {
            char c = S.charAt(i);
            if (c >= 'a' && c <= 'z') {
                totalLen[i] = totalLen[i-1] + 1;
            } else {
                totalLen[i] = totalLen[i-1] * (c - '0');
            }
        }
        
        for (int i = len-1; i >= 0; i--) {
            char c = S.charAt(i);
            if (totalLen[i] < K) {
                k = (k-1) % totalLen[i] + 1;
            }
            if (totalLen[i] == k) {
                while (c >= '0' && c <= '9') c = S.charAt(--i);
                return c + "";
            }
        }
        
        return "";
    }
}
