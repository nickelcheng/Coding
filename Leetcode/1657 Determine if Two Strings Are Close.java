class Solution {
    public boolean closeStrings(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 != len2) return false;
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < 26; i++) {
            cnt1[i] = 0;
            cnt2[i] = 0;
        }
        for (int i = 0; i < len1; i++) {
            cnt1[word1.charAt(i)-'a']++;
            cnt2[word2.charAt(i)-'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] == 0 && cnt2[i] != 0 || cnt1[i] != 0 && cnt2[i] == 0) return false;
            for (int j = 0; j < 26; j++) {
                if (cnt1[i] == cnt2[j])
                {
                    cnt2[j] = -1;
                    break;
                }
            }
        }
        boolean close = true;
        for (int i = 0; i < 26 && close; i++) {
            close = close && cnt2[i] == -1;
        }
        return close;
    }
}
