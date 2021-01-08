class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int pt1 = 0;
        int idx1 = 0;
        int pt2 = 0;
        int idx2 = 0;
        while (idx1 < word1.length && idx2 < word2.length) {
            if (word1[idx1].charAt(pt1) != word2[idx2].charAt(pt2)) return false;
            pt1++;
            pt2++;
            if (pt1 == word1[idx1].length()) {
                pt1 = 0;
                idx1++;
            }
            if (pt2 == word2[idx2].length()) {
                pt2 = 0;
                idx2++;
            }
        }
        return (idx1 == word1.length && idx2 == word2.length);
    }
}
