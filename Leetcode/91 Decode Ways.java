class Solution {
    public int numDecodings(String s) {
        return merge(s, 0, s.length()-1);
    }
    
    int merge(String s, int start, int end) {
        if (start > end) return 1;
        if (start == end) return s.charAt(end) == '0' ? 0 : 1;
        int mid = (start + end) / 2;
        int ans = merge(s, start, mid) * merge(s, mid+1, end);
        if (isValid(s.charAt(mid)-'0', s.charAt(mid+1)-'0')) {
            ans += merge(s, start, mid-1) * merge(s, mid+2, end);
        }
        return ans;
    }
    
    boolean isValid(int a, int b) {
        if (a != 1 && a != 2) return false;
        return a*10 + b <= 26;
    }
}
