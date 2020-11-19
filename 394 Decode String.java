class Solution {
    class Result {
        int k;
        String s;
        int len;
        public Result() {
            k = 0;
            s = "";
            len = 0;
        }
    }
    
    public String decodeString(String s) {
        String ans = "";
        int pt = 0;
        while (pt < s.length()) {
            char c = s.charAt(pt);
            if (c <= 'z' && c >= 'a') {
                ans += c;
                pt++;
                continue;
            }
            Result r = desolve(s, pt);
            for (int i = 0; i < r.k; i++) {
                ans += decodeString(r.s);
            }
            pt += r.len;
        }
        return ans;
    }
    
    private Result desolve(String s, int pt) {
        Result r = new Result();
        int start = pt;
        while (pt < s.length() && s.charAt(pt) != '[') {
            r.k *= 10;
            r.k += s.charAt(pt) - '0';
            pt++;
        }
        pt++;
        int lv = 1;
        while (lv > 0) {
            char c = s.charAt(pt++);
            if (c == '[') lv++;
            if (c == ']') lv--;
            if (lv > 0) r.s += c;
        }
        r.len = pt - start;
        return r;
    }
}
