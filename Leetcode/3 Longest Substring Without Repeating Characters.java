class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len <= 1) return len;
        
        boolean[] seen = new boolean[128];
        int start = 0;
        int end = 1;
        int max = 1;
        seen[s.charAt(0)] = true;
        while (end < len) {
            char c = s.charAt(end++);
            while (seen[c]) {
                seen[s.charAt(start++)] = false;
            }
            seen[c] = true;
            max = Math.max(max, end - start);
        }
        return max;
    }
}
