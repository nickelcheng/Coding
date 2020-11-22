class Solution {
    class Interval {
        int start;
        int end;
        public Interval() {
            start = -1;
            end = -1;
        }
        public Interval(int s, int t) {
            start = s;
            end = t;
        }
        public int getLen() {
            return end - start + 1;
        }
    }
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        int ans = 0;
        Interval longest = new Interval();
        for (int i = 0; i < s.length()-1; i++) {
            Interval odd = checkPalindrome(s, i, i);
            if (ans < odd.getLen()) {
                ans = odd.getLen();
                longest = odd;
            }
            Interval even = checkPalindrome(s, i, i+1);
             if (ans < even.getLen()) {
                ans = even.getLen();
                longest = even;
            }
        }
        return s.substring(longest.start, longest.end + 1);
    }
    
    private Interval checkPalindrome(String s, int fPt, int rPt) {
        if (s.charAt(fPt) != s.charAt(rPt))
            return new Interval(fPt, fPt);
        
        while (fPt >= 0 && rPt < s.length()) {
            if (s.charAt(fPt) != s.charAt(rPt)) {
                break;
            }
            fPt--;
            rPt++;
        }
        return new Interval(fPt+1, rPt-1);
    }
}
