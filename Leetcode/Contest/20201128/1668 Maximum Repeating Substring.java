class Solution {
    public int maxRepeating(String sequence, String word) {
        int ans = 0;
        int sLen = sequence.length();
        int wLen = word.length();
        for (int i = 0; i <= sLen - wLen; i++) {
            boolean match = true;
            int cnt = 0;
            while (match && i + wLen <= sLen) {
                for (int j = 0; j < wLen && match; j++) {
                    if (sequence.charAt(i+j) != word.charAt(j)) {
                        match = false;
                    }
                }
                if (match) {
                    cnt++;
                    i += wLen;
                }
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}
