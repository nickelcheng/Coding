class Solution {
    String ss;
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        ss = s;
        dfs(0, s.length()-1, new ArrayList<>());
        return ans;
    }
    
    private void dfs(int s, int e, List<int[]> candidates) {
        if (s > e) {
            List<String> list = new ArrayList<>();
            candidates.stream().forEach(pair -> list.add(ss.substring(pair[0], pair[1])));
            ans.add(list);
            return;
        }
        for (int i = s; i <= e; i++) {
            if (isPalindrome(s, i)) {
                candidates.add(new int[]{s, i+1});
                dfs(i+1, e, candidates);
                candidates.remove(candidates.size()-1);
            }
        }
    }

    private boolean isPalindrome(int s, int e) {
        for (int i = s, j = e; i < j; i++, j--) {
            if (ss.charAt(i) != ss.charAt(j)) return false;
        }
        return true;
    }
}
