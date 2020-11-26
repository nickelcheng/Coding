class Solution {
    public int longestSubstring(String s, int k) {
        int len = s.length();
        if (len < k) return 0;
        int[] count = new int[26];
        Arrays.fill(count, 0);
        for (int i = 0; i < len; i++) {
            count[s.charAt(i)-'a']++;
        }
        boolean flag = true;
        for (int i = 0; i < 26 && flag; i++) {
            if (count[i] > 0 && count[i] < k) flag = false;
        }
        if (flag) return s.length();
        int h = 0;
        int t = 0;
        int ans = 0;
        while (h < len) {
            if (count[s.charAt(h)-'a'] >= k) {
                for (t = h; t < len && count[s.charAt(t)-'a'] >= k; t++);
                ans = Math.max(ans, longestSubstring(s.substring(h, t), k));
            }
            for (h = t; h < len && count[s.charAt(h)-'a'] < k; h++);
        }
        return ans;
    }
}
// 0:00 start
// 0:55 start to think
// 6:00 we have a O(N^2) solution
// 10:06 start to code
// 19:40 wrong understanding
// 34:30 another O(N^2) solution
// 47:43 AC
