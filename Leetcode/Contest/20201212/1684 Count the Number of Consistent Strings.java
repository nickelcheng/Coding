class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] ch = new boolean[26];
        for (int i = 0; i < allowed.length(); i++) {
            ch[allowed.charAt(i)-'a'] = true;
        }
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            boolean ok = true;
            for (int j = 0; j < words[i].length() && ok; j++) {
                if (!ch[words[i].charAt(j)-'a']) {
                    ok = false;
                }
            }
            if (ok) ans++;
        }
        return ans;
    }
}
